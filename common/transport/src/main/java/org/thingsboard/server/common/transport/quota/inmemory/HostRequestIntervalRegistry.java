/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport.quota.inmemory;

import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
@Component
@Slf4j
public class HostRequestIntervalRegistry {

    private final Map<String, IntervalCount> hostCounts = new ConcurrentHashMap<>();
    private final long intervalDurationMs;
    private final long ttlMs;
    private final Set<String> whiteList;
    private final Set<String> blackList;

    public HostRequestIntervalRegistry(@Value("${quota.host.intervalMs}") long intervalDurationMs,
                                       @Value("${quota.host.ttlMs}") long ttlMs,
                                       @Value("${quota.host.whitelist}") String whiteList,
                                       @Value("${quota.host.blacklist}") String blackList) {
        this.intervalDurationMs = intervalDurationMs;
        this.ttlMs = ttlMs;
        this.whiteList = Sets.newHashSet(StringUtils.split(whiteList, ','));
        this.blackList = Sets.newHashSet(StringUtils.split(blackList, ','));
    }

    @PostConstruct
    public void init() {
        if (ttlMs < intervalDurationMs) {
            log.warn("TTL for IntervalRegistry [{}] smaller than interval duration [{}]", ttlMs, intervalDurationMs);
        }
        log.info("Start Host Quota Service with whitelist {}", whiteList);
        log.info("Start Host Quota Service with blacklist {}", blackList);
    }

    public long tick(String clientHostId) {
        IntervalCount intervalCount = hostCounts.computeIfAbsent(clientHostId, s -> new IntervalCount(intervalDurationMs));
        long currentCount = intervalCount.resetIfExpiredAndTick();
        if (whiteList.contains(clientHostId)) {
            return 0;
        } else if (blackList.contains(clientHostId)) {
            return Long.MAX_VALUE;
        }
        return currentCount;
    }

    public void clean() {
        hostCounts.entrySet().removeIf(entry -> entry.getValue().silenceDuration() > ttlMs);
    }

    public Map<String, Long> getContent() {
        return hostCounts.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        interval -> interval.getValue().getCount()));
    }
}
