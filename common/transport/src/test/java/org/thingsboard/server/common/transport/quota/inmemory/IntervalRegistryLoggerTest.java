/**
 *
 */
package org.thingsboard.server.common.transport.quota.inmemory;

import com.google.common.collect.ImmutableMap;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public class IntervalRegistryLoggerTest {

    private IntervalRegistryLogger logger;

    private HostRequestIntervalRegistry requestRegistry = mock(HostRequestIntervalRegistry.class);

    @Before
    public void init() {
        logger = new IntervalRegistryLogger(3, 10, requestRegistry);
    }

    @Test
    public void onlyMaxHostsCollected() {
        Map<String, Long> map = ImmutableMap.of("a", 8L, "b", 3L, "c", 1L, "d", 3L);
        Map<String, Long> actual = logger.getTopElements(map);
        Map<String, Long> expected = ImmutableMap.of("a", 8L, "b", 3L, "d", 3L);

        assertEquals(expected, actual);
    }

    @Test
    public void emptyMapProcessedCorrectly() {
        Map<String, Long> map = Collections.emptyMap();
        Map<String, Long> actual = logger.getTopElements(map);
        Map<String, Long> expected = Collections.emptyMap();

        assertEquals(expected, actual);
    }

}