/**
 *
 */
package org.thingsboard.server.common.msg.session;

public interface AdaptorToSessionActorMsg extends SessionMsg {

    FromDeviceMsg getMsg();

}
