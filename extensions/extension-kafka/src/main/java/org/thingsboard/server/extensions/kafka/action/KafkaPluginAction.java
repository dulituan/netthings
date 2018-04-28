/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.kafka.action;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;

import java.util.Optional;

@Action(name = "Kafka Plugin Action", descriptor = "KafkaActionDescriptor.json", configuration = KafkaPluginActionConfiguration.class)
@Slf4j
public class KafkaPluginAction extends AbstractTemplatePluginAction<KafkaPluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        KafkaActionPayload.KafkaActionPayloadBuilder builder = KafkaActionPayload.builder();
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.sync(configuration.isSync());
        builder.topic(configuration.getTopic());
        builder.msgBody(getMsgBody(ctx, msg));
        return Optional.of(new KafkaActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }
}
