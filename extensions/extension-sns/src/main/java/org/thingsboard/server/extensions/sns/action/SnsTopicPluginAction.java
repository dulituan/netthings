/**
 *
 */
package org.thingsboard.server.extensions.sns.action;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;

import java.util.Optional;

/**
 * Created by Valerii Sosliuk on 11/15/2017.
 */
@Action(name = "SNS Topic Action", descriptor = "SnsTopicActionDescriptor.json", configuration = SnsTopicPluginActionConfiguration.class)
public class SnsTopicPluginAction extends AbstractTemplatePluginAction<SnsTopicPluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        SnsTopicActionPayload.SnsTopicActionPayloadBuilder builder = SnsTopicActionPayload.builder();
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.topicArn(configuration.getTopicArn());
        builder.msgBody(getMsgBody(ctx, msg));
        return Optional.of(new SnsTopicActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }
}
