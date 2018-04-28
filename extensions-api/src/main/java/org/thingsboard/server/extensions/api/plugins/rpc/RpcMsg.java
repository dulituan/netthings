/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.rpc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.thingsboard.server.common.msg.cluster.ServerAddress;

/**
 * @author Andrew Shvayka
 */
@ToString
@RequiredArgsConstructor
public class RpcMsg {
    @Getter
    private final ServerAddress serverAddress;
    @Getter
    private final int msgClazz;
    @Getter
    private final byte[] msgData;
}
