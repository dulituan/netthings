/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.rpc;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.extensions.api.component.Plugin;
import org.thingsboard.server.extensions.api.plugins.AbstractPlugin;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.DefaultRuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.handlers.RestMsgHandler;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.msg.FromDeviceRpcResponse;
import org.thingsboard.server.extensions.api.plugins.msg.TimeoutMsg;
import org.thingsboard.server.extensions.core.action.rpc.ServerSideRpcCallAction;
import org.thingsboard.server.extensions.core.plugin.rpc.handlers.RpcRestMsgHandler;
import org.thingsboard.server.extensions.core.plugin.rpc.handlers.RpcRuleMsgHandler;

/**
 * @author Andrew Shvayka
 */
@Plugin(name = "RPC Plugin", actions = {ServerSideRpcCallAction.class}, descriptor = "RpcPluginDescriptor.json", configuration = RpcPluginConfiguration.class)
@Slf4j
public class RpcPlugin extends AbstractPlugin<RpcPluginConfiguration> {

    private final RpcManager rpcManager;
    private final RpcRestMsgHandler restMsgHandler;

    public RpcPlugin() {
        this.rpcManager = new RpcManager();
        this.restMsgHandler = new RpcRestMsgHandler(rpcManager);
        this.rpcManager.setRestHandler(restMsgHandler);
    }

    @Override
    public void process(PluginContext ctx, FromDeviceRpcResponse msg) {
        rpcManager.process(ctx, msg);
    }

    @Override
    public void process(PluginContext ctx, TimeoutMsg<?> msg) {
        rpcManager.process(ctx, msg);
    }

    @Override
    protected RestMsgHandler getRestMsgHandler() {
        return restMsgHandler;
    }

    @Override
    public void init(RpcPluginConfiguration configuration) {
        restMsgHandler.setDefaultTimeout(configuration.getDefaultTimeout());
    }

    @Override
    protected RuleMsgHandler getRuleMsgHandler() {
        return new RpcRuleMsgHandler();
    }

    @Override
    public void resume(PluginContext ctx) {
        //Do nothing
    }

    @Override
    public void suspend(PluginContext ctx) {
        //Do nothing
    }

    @Override
    public void stop(PluginContext ctx) {
        //Do nothing
    }
}
