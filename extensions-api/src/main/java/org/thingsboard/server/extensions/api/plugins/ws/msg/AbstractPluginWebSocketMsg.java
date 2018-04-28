/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.PluginApiCallSecurityContext;
import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;

import java.io.Serializable;

public abstract class AbstractPluginWebSocketMsg<T> implements PluginWebsocketMsg<T> {

    private static final long serialVersionUID = 1L;

    private final PluginWebsocketSessionRef sessionRef;
    private final transient T payload;

    AbstractPluginWebSocketMsg(PluginWebsocketSessionRef sessionRef, T payload) {
        this.sessionRef = sessionRef;
        this.payload = payload;
    }

    public PluginWebsocketSessionRef getSessionRef() {
        return sessionRef;
    }


    @Override
    public TenantId getPluginTenantId(){
        return sessionRef.getPluginTenantId();
    }

    @Override
    public PluginId getPluginId() {
        return sessionRef.getPluginId();
    }

    @Override
    public PluginApiCallSecurityContext getSecurityCtx() {
        return sessionRef.getSecurityCtx();
    }

    public T getPayload() {
        return payload;
    }

    @Override
    public String toString() {
        return "AbstractPluginWebSocketMsg [sessionRef=" + sessionRef + ", payload=" + payload + "]";
    }

}
