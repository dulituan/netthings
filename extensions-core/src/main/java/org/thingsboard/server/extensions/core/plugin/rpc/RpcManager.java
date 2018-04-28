/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.rpc;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.msg.*;
import org.thingsboard.server.extensions.core.plugin.rpc.handlers.RpcRestMsgHandler;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author Andrew Shvayka
 */
@Slf4j
public class RpcManager {

    @Setter
    private RpcRestMsgHandler restHandler;

    private Map<UUID, LocalRequestMetaData> localRpcRequests = new HashMap<>();

    public void process(PluginContext ctx, LocalRequestMetaData requestMd) {
        ToDeviceRpcRequest request = requestMd.getRequest();
        log.trace("[{}] Processing local rpc call for device [{}]", request.getId(), request.getDeviceId());
        ctx.sendRpcRequest(request);
        localRpcRequests.put(request.getId(), requestMd);
        ctx.scheduleTimeoutMsg(new TimeoutUUIDMsg(request.getId(), request.getExpirationTime() - System.currentTimeMillis()));
    }

    public void process(PluginContext ctx, FromDeviceRpcResponse response) {
        UUID requestId = response.getId();
        LocalRequestMetaData md = localRpcRequests.remove(requestId);
        if (md != null) {
            log.trace("[{}] Processing local rpc response from device [{}]", requestId, md.getRequest().getDeviceId());
            restHandler.reply(ctx, md.getRequest(), md.getResponseWriter(), response);
        } else {
            log.trace("[{}] Unknown or stale rpc response received [{}]", requestId, response);
        }
    }

    public void process(PluginContext ctx, TimeoutMsg msg) {
        if (msg instanceof TimeoutUUIDMsg) {
            UUID requestId = ((TimeoutUUIDMsg) msg).getId();
            FromDeviceRpcResponse timeoutReponse = new FromDeviceRpcResponse(requestId, null, RpcError.TIMEOUT);
            LocalRequestMetaData md = localRpcRequests.remove(requestId);
            if (md != null) {
                log.trace("[{}] Processing rpc timeout for local device [{}]", requestId, md.getRequest().getDeviceId());
                restHandler.reply(ctx, md.getRequest(), md.getResponseWriter(), timeoutReponse);
            }
        }
    }
}
