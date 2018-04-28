/**
 *
 */
package org.thingsboard.server.extensions.sqs.action.standard;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;

import java.util.Optional;

/**
 * Created by Valerii Sosliuk on 11/5/2017.
 */
@Action(name = "SQS Standard Queue Action", descriptor = "SqsStandardQueueActionDescriptor.json", configuration = SqsStandardQueuePluginActionConfiguration.class)
public class SqsStandardQueuePluginAction extends AbstractTemplatePluginAction<SqsStandardQueuePluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        SqsStandardQueueActionPayload.SqsStandardQueueActionPayloadBuilder builder = SqsStandardQueueActionPayload.builder();
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.queue(configuration.getQueue());
        builder.delaySeconds(configuration.getDelaySeconds());
        builder.msgBody(getMsgBody(ctx, msg));
        return Optional.of(new SqsStandardQueueActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }
}
