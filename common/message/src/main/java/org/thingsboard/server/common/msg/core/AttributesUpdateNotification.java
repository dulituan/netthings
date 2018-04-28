/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import lombok.ToString;
import org.thingsboard.server.common.msg.kv.AttributesKVMsg;
import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

@ToString
public class AttributesUpdateNotification implements ToDeviceMsg {

    private static final long serialVersionUID = 1L;

    private AttributesKVMsg data;

    public AttributesUpdateNotification(AttributesKVMsg data) {
        this.data = data;
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.ATTRIBUTES_UPDATE_NOTIFICATION;
    }

    public AttributesKVMsg getData() {
        return data;
    }
}
