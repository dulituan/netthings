/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.handlers;

import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.ws.msg.PluginWebsocketMsg;

/**
 * @author Andrew Shvayka
 */
public interface WebsocketMsgHandler {

    void process(PluginContext ctx, PluginWebsocketMsg<?> wsMsg);

}
