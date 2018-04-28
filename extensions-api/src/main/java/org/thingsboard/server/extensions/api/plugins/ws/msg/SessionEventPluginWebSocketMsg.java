/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;
import org.thingsboard.server.extensions.api.plugins.ws.SessionEvent;

public class SessionEventPluginWebSocketMsg extends AbstractPluginWebSocketMsg<SessionEvent> {

    private static final long serialVersionUID = 1L;

    public SessionEventPluginWebSocketMsg(PluginWebsocketSessionRef sessionRef, SessionEvent payload) {
        super(sessionRef, payload);
    }

}
