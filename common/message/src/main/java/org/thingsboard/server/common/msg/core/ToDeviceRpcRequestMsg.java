/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToDeviceRpcRequestMsg implements ToDeviceMsg {

    private final int requestId;
    private final String method;
    private final String params;

    @Override
    public MsgType getMsgType() {
        return MsgType.TO_DEVICE_RPC_REQUEST;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }
}
