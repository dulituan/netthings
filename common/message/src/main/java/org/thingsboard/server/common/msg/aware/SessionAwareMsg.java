/**
 *
 */
package org.thingsboard.server.common.msg.aware;

import org.thingsboard.server.common.data.id.SessionId;

public interface SessionAwareMsg {

    SessionId getSessionId();

}
