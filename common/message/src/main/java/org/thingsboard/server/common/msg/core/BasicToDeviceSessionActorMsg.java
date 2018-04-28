/**
 *
 */
package org.thingsboard.server.common.msg.core;

import org.thingsboard.server.common.data.id.SessionId;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

public class BasicToDeviceSessionActorMsg implements ToDeviceSessionActorMsg {

    private final ToDeviceMsg msg;
    private final SessionId sessionId;

    public BasicToDeviceSessionActorMsg(ToDeviceMsg msg, SessionId sessionId) {
        super();
        this.msg = msg;
        this.sessionId = sessionId;
    }

    @Override
    public SessionId getSessionId() {
        return sessionId;
    }

    @Override
    public ToDeviceMsg getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BasicToSessionResponseMsg [msg=" + msg + ", sessionId=" + sessionId + "]";
    }

}
