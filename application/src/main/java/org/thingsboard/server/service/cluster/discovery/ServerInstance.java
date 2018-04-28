/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.cluster.discovery;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.gen.discovery.ServerInstanceProtos.ServerInfo;

/**
 * @author Andrew Shvayka
 */
@ToString
@EqualsAndHashCode(exclude = {"serverInfo", "serverAddress"})
public final class ServerInstance implements Comparable<ServerInstance> {

    @Getter(AccessLevel.PACKAGE)
    private final ServerInfo serverInfo;
    @Getter
    private final String host;
    @Getter
    private final int port;
    @Getter
    private final ServerAddress serverAddress;

    public ServerInstance(ServerInfo serverInfo) {
        this.serverInfo = serverInfo;
        this.host = serverInfo.getHost();
        this.port = serverInfo.getPort();
        this.serverAddress = new ServerAddress(host, port);
    }

    @Override
    public int compareTo(ServerInstance o) {
        return this.serverAddress.compareTo(o.serverAddress);
    }
}
