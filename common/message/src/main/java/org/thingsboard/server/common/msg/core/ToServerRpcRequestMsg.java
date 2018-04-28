/**
 *
 */
package org.thingsboard.server.common.msg.core;

import lombok.Data;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.common.msg.session.MsgType;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToServerRpcRequestMsg implements FromDeviceRequestMsg {

    private final Integer requestId;
    private final String method;
    private final String params;

    @Override
    public MsgType getMsgType() {
        return MsgType.TO_SERVER_RPC_REQUEST;
    }
}
