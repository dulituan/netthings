/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.telemetry;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.extensions.api.component.EmptyComponentConfiguration;
import org.thingsboard.server.extensions.api.component.Plugin;
import org.thingsboard.server.extensions.api.plugins.AbstractPlugin;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.RestMsgHandler;
import org.thingsboard.server.extensions.api.plugins.handlers.RpcMsgHandler;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.handlers.WebsocketMsgHandler;
import org.thingsboard.server.extensions.core.action.telemetry.TelemetryPluginAction;
import org.thingsboard.server.extensions.core.plugin.telemetry.handlers.TelemetryRestMsgHandler;
import org.thingsboard.server.extensions.core.plugin.telemetry.handlers.TelemetryRpcMsgHandler;
import org.thingsboard.server.extensions.core.plugin.telemetry.handlers.TelemetryRuleMsgHandler;
import org.thingsboard.server.extensions.core.plugin.telemetry.handlers.TelemetryWebsocketMsgHandler;

@Plugin(name = "Telemetry Plugin", actions = {TelemetryPluginAction.class})
@Slf4j
public class TelemetryStoragePlugin extends AbstractPlugin<EmptyComponentConfiguration> {

    private final TelemetryRestMsgHandler restMsgHandler;
    private final TelemetryRuleMsgHandler ruleMsgHandler;
    private final TelemetryWebsocketMsgHandler websocketMsgHandler;
    private final TelemetryRpcMsgHandler rpcMsgHandler;
    private final SubscriptionManager subscriptionManager;

    public TelemetryStoragePlugin() {
        this.subscriptionManager = new SubscriptionManager();
        this.restMsgHandler = new TelemetryRestMsgHandler(subscriptionManager);
        this.ruleMsgHandler = new TelemetryRuleMsgHandler(subscriptionManager);
        this.websocketMsgHandler = new TelemetryWebsocketMsgHandler(subscriptionManager);
        this.rpcMsgHandler = new TelemetryRpcMsgHandler(subscriptionManager);
        this.subscriptionManager.setWebsocketHandler(this.websocketMsgHandler);
        this.subscriptionManager.setRpcHandler(this.rpcMsgHandler);
    }

    @Override
    public void init(EmptyComponentConfiguration configuration) {
        //Do nothing
    }

    @Override
    protected RestMsgHandler getRestMsgHandler() {
        return restMsgHandler;
    }

    @Override
    protected RuleMsgHandler getRuleMsgHandler() {
        return ruleMsgHandler;
    }

    @Override
    protected WebsocketMsgHandler getWebsocketMsgHandler() {
        return websocketMsgHandler;
    }

    @Override
    protected RpcMsgHandler getRpcMsgHandler() {
        return rpcMsgHandler;
    }

    @Override
    public void onServerAdded(PluginContext ctx, ServerAddress server) {
        subscriptionManager.onClusterUpdate(ctx);
    }

    @Override
    public void onServerRemoved(PluginContext ctx, ServerAddress server) {
        subscriptionManager.onClusterUpdate(ctx);
    }


    @Override
    public void resume(PluginContext ctx) {
        log.info("Plugin activated!");
    }

    @Override
    public void suspend(PluginContext ctx) {
        log.info("Plugin suspended!");
    }

    @Override
    public void stop(PluginContext ctx) {
        subscriptionManager.clear();
        websocketMsgHandler.clear(ctx);
        log.info("Plugin stopped!");
    }
}
