/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;

public class PingPluginWebsocketMsg extends EmptyPluginWebsocketMsg {

    private static final long serialVersionUID = 1L;

    public PingPluginWebsocketMsg(PluginWebsocketSessionRef sessionRef) {
        super(sessionRef);
    }
}
