/**
 *
 */
package org.thingsboard.server.dao.util;

import com.google.common.util.concurrent.*;
import org.junit.Test;
import org.thingsboard.server.dao.exception.BufferLimitException;

import javax.annotation.Nullable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.*;


public class BufferedRateLimiterTest {

    @Test
    public void finishedFutureReturnedIfPermitsAreGranted() {
        BufferedRateLimiter limiter = new BufferedRateLimiter(10, 10, 100);
        ListenableFuture<Void> actual = limiter.acquireAsync();
        assertTrue(actual.isDone());
    }

    @Test
    public void notFinishedFutureReturnedIfPermitsAreNotGranted() {
        BufferedRateLimiter limiter = new BufferedRateLimiter(10, 1, 100);
        ListenableFuture<Void> actual1 = limiter.acquireAsync();
        ListenableFuture<Void> actual2 = limiter.acquireAsync();
        assertTrue(actual1.isDone());
        assertFalse(actual2.isDone());
    }

    @Test
    public void failedFutureReturnedIfQueueIsfull() {
        BufferedRateLimiter limiter = new BufferedRateLimiter(1, 1, 100);
        ListenableFuture<Void> actual1 = limiter.acquireAsync();
        ListenableFuture<Void> actual2 = limiter.acquireAsync();
        ListenableFuture<Void> actual3 = limiter.acquireAsync();

        assertTrue(actual1.isDone());
        assertFalse(actual2.isDone());
        assertTrue(actual3.isDone());
        try {
            actual3.get();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof ExecutionException);
            Throwable actualCause = e.getCause();
            assertTrue(actualCause instanceof BufferLimitException);
            assertEquals("Rate Limit Buffer is full", actualCause.getMessage());
        }
    }

    @Test
    public void releasedPermitTriggerTasksFromQueue() throws InterruptedException {
        BufferedRateLimiter limiter = new BufferedRateLimiter(10, 2, 100);
        ListenableFuture<Void> actual1 = limiter.acquireAsync();
        ListenableFuture<Void> actual2 = limiter.acquireAsync();
        ListenableFuture<Void> actual3 = limiter.acquireAsync();
        ListenableFuture<Void> actual4 = limiter.acquireAsync();
        assertTrue(actual1.isDone());
        assertTrue(actual2.isDone());
        assertFalse(actual3.isDone());
        assertFalse(actual4.isDone());
        limiter.release();
        TimeUnit.MILLISECONDS.sleep(100L);
        assertTrue(actual3.isDone());
        assertFalse(actual4.isDone());
        limiter.release();
        TimeUnit.MILLISECONDS.sleep(100L);
        assertTrue(actual4.isDone());
    }

    @Test
    public void permitsReleasedInConcurrentMode() throws InterruptedException {
        BufferedRateLimiter limiter = new BufferedRateLimiter(10, 2, 100);
        AtomicInteger actualReleased = new AtomicInteger();
        AtomicInteger actualRejected = new AtomicInteger();
        ListeningExecutorService pool = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(5));
        for (int i = 0; i < 100; i++) {
            ListenableFuture<ListenableFuture<Void>> submit = pool.submit(limiter::acquireAsync);
            Futures.addCallback(submit, new FutureCallback<ListenableFuture<Void>>() {
                @Override
                public void onSuccess(@Nullable ListenableFuture<Void> result) {
                    Futures.addCallback(result, new FutureCallback<Void>() {
                        @Override
                        public void onSuccess(@Nullable Void result) {
                            try {
                                TimeUnit.MILLISECONDS.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            limiter.release();
                            actualReleased.incrementAndGet();
                        }

                        @Override
                        public void onFailure(Throwable t) {
                            actualRejected.incrementAndGet();
                        }
                    });
                }

                @Override
                public void onFailure(Throwable t) {
                }
            });
        }

        TimeUnit.SECONDS.sleep(2);
        assertTrue("Unexpected released count " + actualReleased.get(),
                actualReleased.get() > 10 && actualReleased.get() < 20);
        assertTrue("Unexpected rejected count " + actualRejected.get(),
                actualRejected.get() > 80 && actualRejected.get() < 90);

    }


}