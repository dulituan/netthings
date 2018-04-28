/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins;

import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.extensions.api.plugins.handlers.*;
import org.thingsboard.server.extensions.api.plugins.msg.FromDeviceRpcResponse;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.plugins.msg.TimeoutMsg;
import org.thingsboard.server.extensions.api.plugins.rest.PluginRestMsg;
import org.thingsboard.server.extensions.api.plugins.rpc.RpcMsg;
import org.thingsboard.server.extensions.api.plugins.ws.msg.PluginWebsocketMsg;
import org.thingsboard.server.extensions.api.rules.RuleException;

/**
 * @author Andrew Shvayka
 */
public abstract class AbstractPlugin<T> implements Plugin<T> {

    @Override
    public void process(PluginContext ctx, PluginWebsocketMsg<?> wsMsg) {
        getWebsocketMsgHandler().process(ctx, wsMsg);
    }

    @Override
    public void process(PluginContext ctx, PluginRestMsg msg) {
        getRestMsgHandler().process(ctx, msg);
    }

    @Override
    public void process(PluginContext ctx, TenantId tenantId, RuleId ruleId, RuleToPluginMsg<?> msg) throws RuleException {
        getRuleMsgHandler().process(ctx, tenantId, ruleId, msg);
    }

    @Override
    public void process(PluginContext ctx, RpcMsg msg) {
        getRpcMsgHandler().process(ctx, msg);
    }

    @Override
    public void process(PluginContext ctx, FromDeviceRpcResponse msg) {
        throw new IllegalStateException("Device RPC messages is not handled in current plugin!");
    }

    @Override
    public void process(PluginContext ctx, TimeoutMsg<?> msg) {
        throw new IllegalStateException("Timeouts is not handled in current plugin!");
    }

    @Override
    public void onServerAdded(PluginContext ctx, ServerAddress server) {
    }

    @Override
    public void onServerRemoved(PluginContext ctx, ServerAddress server) {
    }

    protected RuleMsgHandler getRuleMsgHandler() {
        return new DefaultRuleMsgHandler();
    }

    protected RestMsgHandler getRestMsgHandler() {
        return new DefaultRestMsgHandler();
    }

    protected WebsocketMsgHandler getWebsocketMsgHandler() {
        return new DefaultWebsocketMsgHandler();
    }

    protected RpcMsgHandler getRpcMsgHandler() {
        return new DefaultRpcMsgHandler();
    }
}
