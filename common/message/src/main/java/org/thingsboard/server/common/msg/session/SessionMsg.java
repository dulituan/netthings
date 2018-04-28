/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.session;

import org.thingsboard.server.common.msg.aware.SessionAwareMsg;

public interface SessionMsg extends SessionAwareMsg {

    SessionContext getSessionContext();

}
