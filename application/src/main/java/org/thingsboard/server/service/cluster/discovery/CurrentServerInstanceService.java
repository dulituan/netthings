/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.cluster.discovery;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.thingsboard.server.gen.discovery.ServerInstanceProtos;

import javax.annotation.PostConstruct;

import static org.thingsboard.server.utils.MiscUtils.missingProperty;

/**
 * @author Andrew Shvayka
 */
@Service
@Slf4j
public class CurrentServerInstanceService implements ServerInstanceService {

    @Value("${rpc.bind_host}")
    private String rpcHost;
    @Value("${rpc.bind_port}")
    private Integer rpcPort;

    private ServerInstance self;

    @PostConstruct
    public void init() {
        Assert.hasLength(rpcHost, missingProperty("rpc.bind_host"));
        Assert.notNull(rpcPort, missingProperty("rpc.bind_port"));

        self = new ServerInstance(ServerInstanceProtos.ServerInfo.newBuilder().setHost(rpcHost).setPort(rpcPort).setTs(System.currentTimeMillis()).build());
        log.info("Current server instance: [{};{}]", self.getHost(), self.getPort());
    }

    @Override
    public ServerInstance getSelf() {
        return self;
    }
}
