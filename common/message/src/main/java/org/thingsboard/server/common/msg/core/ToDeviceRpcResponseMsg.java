/**
 *
 */
package org.thingsboard.server.common.msg.core;

import lombok.Data;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.MsgType;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToDeviceRpcResponseMsg implements FromDeviceMsg {

    private final int requestId;
    private final String data;

    @Override
    public MsgType getMsgType() {
        return MsgType.TO_DEVICE_RPC_RESPONSE;
    }
}
