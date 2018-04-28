/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.session;

public interface SessionActorToAdaptorMsg extends SessionMsg {

    ToDeviceMsg getMsg();

}
