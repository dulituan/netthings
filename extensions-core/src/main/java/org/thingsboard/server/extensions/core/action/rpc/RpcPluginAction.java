/**
 *
 */
package org.thingsboard.server.extensions.core.action.rpc;

import org.thingsboard.server.common.msg.core.ToServerRpcRequestMsg;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.component.EmptyComponentConfiguration;
import org.thingsboard.server.extensions.api.plugins.PluginAction;
import org.thingsboard.server.extensions.api.plugins.msg.PluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RpcRequestRuleToPluginMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RpcResponsePluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.api.rules.RuleProcessingMetaData;
import org.thingsboard.server.extensions.api.rules.SimpleRuleLifecycleComponent;

import java.util.Optional;

@Action(name = "RPC Plugin Action")
public class RpcPluginAction extends SimpleRuleLifecycleComponent implements PluginAction<EmptyComponentConfiguration> {

    public void init(EmptyComponentConfiguration configuration) {
        //Do nothing
    }

    @Override
    public Optional<RuleToPluginMsg> convert(RuleContext ctx, ToDeviceActorMsg toDeviceActorMsg, RuleProcessingMetaData deviceMsgMd) {
        FromDeviceMsg msg = toDeviceActorMsg.getPayload();
        if (msg.getMsgType() == MsgType.TO_SERVER_RPC_REQUEST) {
            ToServerRpcRequestMsg payload = (ToServerRpcRequestMsg) msg;
            return Optional.of(new RpcRequestRuleToPluginMsg(toDeviceActorMsg.getTenantId(), toDeviceActorMsg.getCustomerId(),
                    toDeviceActorMsg.getDeviceId(), payload));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<ToDeviceMsg> convert(PluginToRuleMsg<?> response) {
        if (response instanceof RpcResponsePluginToRuleMsg) {
            return Optional.of(((RpcResponsePluginToRuleMsg) response).getPayload());
        }
        return Optional.empty();
    }

    @Override
    public boolean isOneWayAction() {
        return false;
    }

}
