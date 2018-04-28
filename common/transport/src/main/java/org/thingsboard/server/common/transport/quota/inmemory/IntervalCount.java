/**
 *
 */
package org.thingsboard.server.common.transport.quota.inmemory;


import org.thingsboard.server.common.transport.quota.Clock;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public class IntervalCount {

    private final LongAdder adder = new LongAdder();
    private final long intervalDurationMs;
    private volatile long startTime;
    private volatile long lastTickTime;

    public IntervalCount(long intervalDurationMs) {
        this.intervalDurationMs = intervalDurationMs;
        startTime = Clock.millis();
    }

    public long resetIfExpiredAndTick() {
        if (isExpired()) {
            reset();
        }
        tick();
        return adder.sum();
    }

    public long silenceDuration() {
        return Clock.millis() - lastTickTime;
    }

    public long getCount() {
        return adder.sum();
    }

    private void tick() {
        adder.add(1);
        lastTickTime = Clock.millis();
    }

    private void reset() {
        adder.reset();
        startTime = Clock.millis();
    }

    private boolean isExpired() {
        return (Clock.millis() - startTime) > intervalDurationMs;
    }
}
