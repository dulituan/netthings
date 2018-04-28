/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.MsgType;

/**
 * @author Andrew Shvayka
 */
public class RpcUnsubscribeMsg implements FromDeviceMsg {
    @Override
    public MsgType getMsgType() {
        return MsgType.UNSUBSCRIBE_RPC_COMMANDS_REQUEST;
    }
}
