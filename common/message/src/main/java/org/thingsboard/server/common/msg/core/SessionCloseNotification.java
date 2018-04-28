/**
 *
 */
package org.thingsboard.server.common.msg.core;

import lombok.ToString;
import org.thingsboard.server.common.msg.kv.AttributesKVMsg;
import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

@ToString
public class SessionCloseNotification implements ToDeviceMsg {

    private static final long serialVersionUID = 1L;

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.SESSION_CLOSE;
    }

}
