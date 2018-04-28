/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws;

import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.PluginApiCallSecurityContext;

import java.io.Serializable;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

public interface PluginWebsocketSessionRef extends Serializable {

    String getSessionId();

    TenantId getPluginTenantId();

    PluginId getPluginId();

    URI getUri();

    Map<String, Object> getAttributes();

    InetSocketAddress getLocalAddress();

    InetSocketAddress getRemoteAddress();

    PluginApiCallSecurityContext getSecurityCtx();

}
