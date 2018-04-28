/**
 *
 */
package org.thingsboard.server.common.msg.session;

import org.thingsboard.server.common.data.security.DeviceCredentialsFilter;
import org.thingsboard.server.common.msg.aware.SessionAwareMsg;
import org.thingsboard.server.common.msg.session.ex.SessionException;

public interface SessionContext extends SessionAwareMsg {

    SessionType getSessionType();

    void onMsg(SessionActorToAdaptorMsg msg) throws SessionException;

    void onMsg(SessionCtrlMsg msg) throws SessionException;

    boolean isClosed();

    long getTimeout();

}
