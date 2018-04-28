/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.extensions.api.plugins.PluginApiCallSecurityContext;
import org.thingsboard.server.extensions.api.plugins.msg.ToPluginActorMsg;

@SuppressWarnings("rawtypes")
public interface PluginRestMsg extends ToPluginActorMsg {

    RestRequest getRequest();

    DeferredResult<ResponseEntity> getResponseHolder();
    
    PluginApiCallSecurityContext getSecurityCtx();
    
    @Override
    default PluginId getPluginId() {
        return getSecurityCtx().getPluginId();
    }

}
