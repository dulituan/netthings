/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.service;

import org.thingsboard.server.extensions.api.plugins.ws.msg.PluginWebsocketMsg;

public interface WebSocketMsgProcessor {

    void process(PluginWebsocketMsg<?> msg);
    
}
