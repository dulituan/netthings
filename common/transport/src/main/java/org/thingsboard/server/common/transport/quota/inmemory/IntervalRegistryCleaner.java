/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport.quota.inmemory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
@Component
@Slf4j
public class IntervalRegistryCleaner {

    private final HostRequestIntervalRegistry intervalRegistry;
    private final long cleanPeriodMs;
    private ScheduledExecutorService executor;

    public IntervalRegistryCleaner(HostRequestIntervalRegistry intervalRegistry, @Value("${quota.host.cleanPeriodMs}") long cleanPeriodMs) {
        this.intervalRegistry = intervalRegistry;
        this.cleanPeriodMs = cleanPeriodMs;
    }

    public void schedule() {
        if (executor != null) {
            throw new IllegalStateException("Registry Cleaner already scheduled");
        }
        executor = Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(this::clean, cleanPeriodMs, cleanPeriodMs, TimeUnit.MILLISECONDS);
    }

    public void stop() {
        if (executor != null) {
            executor.shutdown();
        }
    }

    public void clean() {
        try {
            intervalRegistry.clean();
        } catch (RuntimeException ex) {
            log.error("Could not clear Interval Registry", ex);
        }
    }

}
