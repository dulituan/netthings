/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.PluginApiCallSecurityContext;

@SuppressWarnings("rawtypes")
public class BasicPluginRestMsg implements PluginRestMsg {

    private final PluginApiCallSecurityContext securityCtx;
    private final RestRequest request;
    private final DeferredResult<ResponseEntity> responseHolder;

    public BasicPluginRestMsg(PluginApiCallSecurityContext securityCtx, RestRequest request,
                              DeferredResult<ResponseEntity> responseHolder) {
        super();
        this.securityCtx = securityCtx;
        this.request = request;
        this.responseHolder = responseHolder;
    }

    @Override
    public PluginApiCallSecurityContext getSecurityCtx() {
        return securityCtx;
    }

    @Override
    public RestRequest getRequest() {
        return request;
    }

    @Override
    public DeferredResult<ResponseEntity> getResponseHolder() {
        return responseHolder;
    }

    @Override
    public PluginId getPluginId() {
        return securityCtx.getPluginId();
    }

    @Override
    public TenantId getPluginTenantId() {
        return securityCtx.getPluginTenantId();
    }
}
