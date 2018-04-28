/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.rpc;

import lombok.Data;
import org.thingsboard.server.common.msg.cluster.ServerAddress;

/**
 * @author Andrew Shvayka
 */
@Data
public final class RpcSessionClosedMsg {

    private final boolean client;
    private final ServerAddress remoteAddress;
}
