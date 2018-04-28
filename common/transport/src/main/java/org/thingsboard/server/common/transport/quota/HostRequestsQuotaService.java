/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport.quota;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thingsboard.server.common.transport.quota.inmemory.HostRequestIntervalRegistry;
import org.thingsboard.server.common.transport.quota.inmemory.IntervalRegistryCleaner;
import org.thingsboard.server.common.transport.quota.inmemory.IntervalRegistryLogger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
@Service
@Slf4j
public class HostRequestsQuotaService implements QuotaService {

    private final HostRequestIntervalRegistry requestRegistry;
    private final HostRequestLimitPolicy requestsPolicy;
    private final IntervalRegistryCleaner registryCleaner;
    private final IntervalRegistryLogger registryLogger;
    private final boolean enabled;

    public HostRequestsQuotaService(HostRequestIntervalRegistry requestRegistry, HostRequestLimitPolicy requestsPolicy,
                                    IntervalRegistryCleaner registryCleaner, IntervalRegistryLogger registryLogger,
                                    @Value("${quota.host.enabled}") boolean enabled) {
        this.requestRegistry = requestRegistry;
        this.requestsPolicy = requestsPolicy;
        this.registryCleaner = registryCleaner;
        this.registryLogger = registryLogger;
        this.enabled = enabled;
    }

    @PostConstruct
    public void init() {
        if (enabled) {
            registryCleaner.schedule();
            registryLogger.schedule();
        }
    }

    @PreDestroy
    public void close() {
        if (enabled) {
            registryCleaner.stop();
            registryLogger.stop();
        }
    }

    @Override
    public boolean isQuotaExceeded(String key) {
        if (enabled) {
            long count = requestRegistry.tick(key);
            return !requestsPolicy.isValid(count);
        }
        return false;
    }
}
