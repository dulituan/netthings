/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import java.io.Serializable;
import java.util.Optional;

import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

public interface ResponseMsg<T extends Serializable> extends ToDeviceMsg {

    MsgType getRequestMsgType();

    Integer getRequestId();

    Optional<Exception> getError();

    Optional<T> getData();
}
