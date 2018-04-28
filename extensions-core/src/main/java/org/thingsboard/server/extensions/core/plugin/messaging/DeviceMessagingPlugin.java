/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.messaging;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.extensions.api.component.Plugin;
import org.thingsboard.server.extensions.api.plugins.AbstractPlugin;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.msg.FromDeviceRpcResponse;
import org.thingsboard.server.extensions.core.action.rpc.RpcPluginAction;

/**
 * @author Andrew Shvayka
 */
@Plugin(name = "Device Messaging Plugin", actions = {RpcPluginAction.class},
        descriptor = "DeviceMessagingPluginDescriptor.json", configuration = DeviceMessagingPluginConfiguration.class)
@Slf4j
public class DeviceMessagingPlugin extends AbstractPlugin<DeviceMessagingPluginConfiguration> {

    private DeviceMessagingRuleMsgHandler ruleHandler;

    public DeviceMessagingPlugin() {
        ruleHandler = new DeviceMessagingRuleMsgHandler();
    }

    @Override
    public void init(DeviceMessagingPluginConfiguration configuration) {
        ruleHandler.setConfiguration(configuration);
    }

    @Override
    public void process(PluginContext ctx, FromDeviceRpcResponse msg) {
        ruleHandler.process(ctx, msg);
    }

    @Override
    protected RuleMsgHandler getRuleMsgHandler() {
        return ruleHandler;
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
