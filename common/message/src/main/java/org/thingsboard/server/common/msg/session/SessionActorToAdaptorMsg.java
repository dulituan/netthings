/**
 *
 */
package org.thingsboard.server.common.msg.session;

public interface SessionActorToAdaptorMsg extends SessionMsg {

    ToDeviceMsg getMsg();

}
