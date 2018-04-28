/**
 *
 */
package org.thingsboard.server.common.transport;

import org.thingsboard.server.common.data.security.DeviceCredentialsFilter;
import org.thingsboard.server.common.msg.aware.SessionAwareMsg;

public interface SessionMsgProcessor {

    void process(SessionAwareMsg msg);

}
