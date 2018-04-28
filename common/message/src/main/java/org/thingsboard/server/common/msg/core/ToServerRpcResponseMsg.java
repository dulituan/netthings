/**
 *
 */
package org.thingsboard.server.common.msg.core;

import lombok.Data;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToServerRpcResponseMsg implements ToDeviceMsg {

    private final int requestId;
    private final String data;

    @Override
    public MsgType getMsgType() {
        return MsgType.TO_SERVER_RPC_RESPONSE;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }
}
