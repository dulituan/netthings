/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.controller.plugin;

import java.io.IOException;

import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;
import org.thingsboard.server.extensions.api.plugins.ws.msg.PluginWebsocketMsg;

public interface PluginWebSocketMsgEndpoint {

    void send(PluginWebsocketMsg<?> wsMsg) throws IOException;

    void close(PluginWebsocketSessionRef sessionRef) throws IOException;
}
