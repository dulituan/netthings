/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sqs.action.fifo;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;
import org.thingsboard.server.extensions.sqs.action.standard.SqsStandardQueueActionMsg;
import org.thingsboard.server.extensions.sqs.action.standard.SqsStandardQueueActionPayload;
import org.thingsboard.server.extensions.sqs.action.standard.SqsStandardQueuePluginActionConfiguration;

import java.util.Optional;

/**
 * Created by Valerii Sosliuk on 11/5/2017.
 */
@Action(name = "SQS Fifo Queue Action", descriptor = "SqsFifoQueueActionDescriptor.json", configuration = SqsFifoQueuePluginActionConfiguration.class)
public class SqsFifoQueuePluginAction extends AbstractTemplatePluginAction<SqsFifoQueuePluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        SqsFifoQueueActionPayload.SqsFifoQueueActionPayloadBuilder builder = SqsFifoQueueActionPayload.builder();
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.queue(configuration.getQueue());
        builder.deviceId(msg.getDeviceId().toString());
        builder.msgBody(getMsgBody(ctx, msg));
        return Optional.of(new SqsFifoQueueActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }
}
