/**
 *
 */
package org.thingsboard.server.extensions.mqtt.action;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;

import java.util.Optional;

@Action(name = "Mqtt Plugin Action", descriptor = "MqttActionDescriptor.json", configuration = MqttPluginActionConfiguration.class)
public class MqttPluginAction extends AbstractTemplatePluginAction<MqttPluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        MqttActionPayload.MqttActionPayloadBuilder builder = MqttActionPayload.builder();
        builder.sync(configuration.isSync());
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.topic(configuration.getTopic());
        builder.msgBody(getMsgBody(ctx, msg));
        return Optional.of(new MqttActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }
}
