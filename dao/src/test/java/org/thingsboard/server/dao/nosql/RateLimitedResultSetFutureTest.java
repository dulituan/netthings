/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.nosql;

import com.datastax.driver.core.*;
import com.datastax.driver.core.exceptions.UnsupportedFeatureException;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.thingsboard.server.dao.exception.BufferLimitException;
import org.thingsboard.server.dao.util.AsyncRateLimiter;

import java.util.concurrent.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class RateLimitedResultSetFutureTest {

    private RateLimitedResultSetFuture resultSetFuture;

    @Mock
    private AsyncRateLimiter rateLimiter;
    @Mock
    private Session session;
    @Mock
    private Statement statement;
    @Mock
    private ResultSetFuture realFuture;
    @Mock
    private ResultSet rows;
    @Mock
    private Row row;

    @Test
    public void doNotReleasePermissionIfRateLimitFutureFailed() throws InterruptedException {
        when(rateLimiter.acquireAsync()).thenReturn(Futures.immediateFailedFuture(new BufferLimitException()));
        resultSetFuture = new RateLimitedResultSetFuture(session, rateLimiter, statement);
        Thread.sleep(1000L);
        verify(rateLimiter).acquireAsync();
        try {
            assertTrue(resultSetFuture.isDone());
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
            Throwable actualCause = e.getCause();
            assertTrue(actualCause instanceof ExecutionException);
        }
        verifyNoMoreInteractions(session, rateLimiter, statement);

    }

    @Test
    public void getUninterruptiblyDelegateToCassandra() throws InterruptedException, ExecutionException {
        when(rateLimiter.acquireAsync()).thenReturn(Futures.immediateFuture(null));
        when(session.executeAsync(statement)).thenReturn(realFuture);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            Runnable task = (Runnable) args[0];
            task.run();
            return null;
        }).when(realFuture).addListener(Mockito.any(), Mockito.any());

        when(realFuture.getUninterruptibly()).thenReturn(rows);

        resultSetFuture = new RateLimitedResultSetFuture(session, rateLimiter, statement);
        ResultSet actual = resultSetFuture.getUninterruptibly();
        assertSame(rows, actual);
        verify(rateLimiter, times(1)).acquireAsync();
        verify(rateLimiter, times(1)).release();
    }

    @Test
    public void addListenerAllowsFutureTransformation() throws InterruptedException, ExecutionException {
        when(rateLimiter.acquireAsync()).thenReturn(Futures.immediateFuture(null));
        when(session.executeAsync(statement)).thenReturn(realFuture);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            Runnable task = (Runnable) args[0];
            task.run();
            return null;
        }).when(realFuture).addListener(Mockito.any(), Mockito.any());

        when(realFuture.get()).thenReturn(rows);
        when(rows.one()).thenReturn(row);

        resultSetFuture = new RateLimitedResultSetFuture(session, rateLimiter, statement);

        ListenableFuture<Row> transform = Futures.transform(resultSetFuture, ResultSet::one);
        Row actualRow = transform.get();

        assertSame(row, actualRow);
        verify(rateLimiter, times(1)).acquireAsync();
        verify(rateLimiter, times(1)).release();
    }

    @Test
    public void immidiateCassandraExceptionReturnsPermit() throws InterruptedException, ExecutionException {
        when(rateLimiter.acquireAsync()).thenReturn(Futures.immediateFuture(null));
        when(session.executeAsync(statement)).thenThrow(new UnsupportedFeatureException(ProtocolVersion.V3, "hjg"));
        resultSetFuture = new RateLimitedResultSetFuture(session, rateLimiter, statement);
        ListenableFuture<Row> transform = Futures.transform(resultSetFuture, ResultSet::one);
        try {
            transform.get();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof ExecutionException);
        }
        verify(rateLimiter, times(1)).acquireAsync();
        verify(rateLimiter, times(1)).release();
    }

    @Test
    public void queryTimeoutReturnsPermit() throws InterruptedException, ExecutionException {
        when(rateLimiter.acquireAsync()).thenReturn(Futures.immediateFuture(null));
        when(session.executeAsync(statement)).thenReturn(realFuture);
        Mockito.doAnswer((Answer<Void>) invocation -> {
            Object[] args = invocation.getArguments();
            Runnable task = (Runnable) args[0];
            task.run();
            return null;
        }).when(realFuture).addListener(Mockito.any(), Mockito.any());

        when(realFuture.get()).thenThrow(new ExecutionException("Fail", new TimeoutException("timeout")));
        resultSetFuture = new RateLimitedResultSetFuture(session, rateLimiter, statement);
        ListenableFuture<Row> transform = Futures.transform(resultSetFuture, ResultSet::one);
        try {
            transform.get();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof ExecutionException);
        }
        verify(rateLimiter, times(1)).acquireAsync();
        verify(rateLimiter, times(1)).release();
    }

    @Test
    public void expiredQueryReturnPermit() throws InterruptedException, ExecutionException {
        CountDownLatch latch = new CountDownLatch(1);
        ListenableFuture<Void> future = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1)).submit(() -> {
            latch.await();
            return null;
        });
        when(rateLimiter.acquireAsync()).thenReturn(future);
        resultSetFuture = new RateLimitedResultSetFuture(session, rateLimiter, statement);

        ListenableFuture<Row> transform = Futures.transform(resultSetFuture, ResultSet::one);
//        TimeUnit.MILLISECONDS.sleep(200);
        future.cancel(false);
        latch.countDown();

        try {
            transform.get();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof ExecutionException);
        }
        verify(rateLimiter, times(1)).acquireAsync();
        verify(rateLimiter, times(1)).release();
    }

}