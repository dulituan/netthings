/**
 *
 */
package org.thingsboard.server.actors.session;

import org.thingsboard.server.actors.shared.ActorTerminationMsg;
import org.thingsboard.server.common.data.id.SessionId;

public class SessionTerminationMsg extends ActorTerminationMsg<SessionId> {

    public SessionTerminationMsg(SessionId id) {
        super(id);
    }
}
