/**
 *
 */
package org.thingsboard.server.extensions.rabbitmq.action;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;

import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
@Action(name = "RabbitMQ Plugin Action",
        descriptor = "RabbitMqActionDescriptor.json", configuration = RabbitMqPluginActionConfiguration.class)
public class RabbitMqPluginAction extends AbstractTemplatePluginAction<RabbitMqPluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        RabbitMqActionPayload.RabbitMqActionPayloadBuilder builder = RabbitMqActionPayload.builder();
        builder.sync(configuration.isSync());
        builder.exchange(configuration.getExchange());
        builder.queueName(configuration.getQueueName());
        builder.messageProperties(configuration.getMessageProperties());
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.payload(getMsgBody(ctx, msg));
        return Optional.of(new RabbitMqActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }
}
