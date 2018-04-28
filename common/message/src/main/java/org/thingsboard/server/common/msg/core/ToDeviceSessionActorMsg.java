/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import org.thingsboard.server.common.msg.aware.SessionAwareMsg;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

import java.io.Serializable;

/**
 * @author Andrew Shvayka
 */
public interface ToDeviceSessionActorMsg extends SessionAwareMsg, Serializable {

    ToDeviceMsg getMsg();
}
