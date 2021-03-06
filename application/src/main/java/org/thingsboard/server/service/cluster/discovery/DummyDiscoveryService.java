/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.cluster.discovery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.thingsboard.server.service.environment.EnvironmentLogService;

import javax.annotation.PostConstruct;
import java.util.Collections;
import java.util.List;

/**
 * @author Andrew Shvayka
 */
@Service
@ConditionalOnProperty(prefix = "zk", value = "enabled", havingValue = "false", matchIfMissing = true)
@Slf4j
@DependsOn("environmentLogService")
public class DummyDiscoveryService implements DiscoveryService {

    @Autowired
    private ServerInstanceService serverInstance;

    @PostConstruct
    public void init() {
        log.info("Initializing...");
    }

    @Override
    public void publishCurrentServer() {
        //Do nothing
    }

    @Override
    public void unpublishCurrentServer() {
        //Do nothing
    }

    @Override
    public ServerInstance getCurrentServer() {
        return serverInstance.getSelf();
    }

    @Override
    public List<ServerInstance> getOtherServers() {
        return Collections.emptyList();
    }

    @Override
    public boolean addListener(DiscoveryServiceListener listener) {
        return false;
    }

    @Override
    public boolean removeListener(DiscoveryServiceListener listener) {
        return false;
    }
}
