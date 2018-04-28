/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.extensions.api.plugins.PluginApiCallSecurityContext;
import org.thingsboard.server.extensions.api.plugins.msg.ToPluginActorMsg;
import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;

import java.io.Serializable;

public interface PluginWebsocketMsg<T> extends ToPluginActorMsg, Serializable {

    PluginWebsocketSessionRef getSessionRef();

    T getPayload();

    PluginApiCallSecurityContext getSecurityCtx();
}
