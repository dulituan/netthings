/**
 *
 */
package org.thingsboard.server.actors.rpc;

import lombok.Data;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.gen.cluster.ClusterAPIProtos;

/**
 * @author Andrew Shvayka
 */
@Data
public final class RpcSessionTellMsg {
    private final ServerAddress serverAddress;
    private final ClusterAPIProtos.ToRpcServerMessage msg;
}
