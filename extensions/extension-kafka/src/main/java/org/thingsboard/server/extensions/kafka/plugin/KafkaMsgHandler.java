/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.kafka.plugin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.BasicStatusCodeResponse;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.msg.ResponsePluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleException;
import org.thingsboard.server.extensions.kafka.action.KafkaActionMsg;
import org.thingsboard.server.extensions.kafka.action.KafkaActionPayload;

@RequiredArgsConstructor
@Slf4j
public class KafkaMsgHandler implements RuleMsgHandler {

    private final Producer<?, String> producer;

    @Override
    public void process(PluginContext ctx, TenantId tenantId, RuleId ruleId, RuleToPluginMsg<?> msg) throws RuleException {
        if (!(msg instanceof KafkaActionMsg)) {
            throw new RuleException("Unsupported message type " + msg.getClass().getName() + "!");
        }
        KafkaActionPayload payload = ((KafkaActionMsg) msg).getPayload();
        log.debug("Processing kafka payload: {}", payload);
        try {
            producer.send(new ProducerRecord<>(payload.getTopic(), payload.getMsgBody()),
                    (metadata, e) -> {
                        if (payload.isSync()) {
                            if (metadata != null) {
                                ctx.reply(new ResponsePluginToRuleMsg(msg.getUid(), tenantId, ruleId,
                                        BasicStatusCodeResponse.onSuccess(payload.getMsgType(), payload.getRequestId())));
                            } else {
                                ctx.reply(new ResponsePluginToRuleMsg(msg.getUid(), tenantId, ruleId,
                                        BasicStatusCodeResponse.onError(payload.getMsgType(), payload.getRequestId(), e)));
                            }
                        }
                    });
        } catch (Exception e) {
            throw new RuleException(e.getMessage(), e);
        }
    }
}
