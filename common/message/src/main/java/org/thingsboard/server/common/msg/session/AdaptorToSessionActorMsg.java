/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.session;

public interface AdaptorToSessionActorMsg extends SessionMsg {

    FromDeviceMsg getMsg();

}
