/**
 *
 */
package org.thingsboard.server.extensions.mqtt.plugin;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.*;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.BasicStatusCodeResponse;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.msg.ResponsePluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleException;
import org.thingsboard.server.extensions.mqtt.action.MqttActionMsg;
import org.thingsboard.server.extensions.mqtt.action.MqttActionPayload;

import java.nio.charset.StandardCharsets;

@RequiredArgsConstructor
@Slf4j
public class MqttMsgHandler implements RuleMsgHandler {

    private final MqttAsyncClient mqttClient;

    @Override
    public void process(PluginContext ctx, TenantId tenantId, RuleId ruleId, RuleToPluginMsg<?> msg) throws RuleException {
        if (!(msg instanceof MqttActionMsg)) {
            throw new RuleException("Unsupported message type " + msg.getClass().getName() + "!");
        }
        MqttActionPayload payload = ((MqttActionMsg) msg).getPayload();
        MqttMessage mqttMsg = new MqttMessage(payload.getMsgBody().getBytes(StandardCharsets.UTF_8));
        try {
            mqttClient.publish(payload.getTopic(), mqttMsg, null, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken asyncActionToken) {
                    log.debug("Message [{}] was successfully delivered to topic [{}]!", msg.toString(), payload.getTopic());
                    if (payload.isSync()) {
                        ctx.reply(new ResponsePluginToRuleMsg(msg.getUid(), tenantId, ruleId,
                                BasicStatusCodeResponse.onSuccess(payload.getMsgType(), payload.getRequestId())));
                    }
                }
                @Override
                public void onFailure(IMqttToken asyncActionToken, Throwable e) {
                    log.warn("Failed to deliver message [{}] to topic [{}]!", msg.toString(), payload.getTopic());
                    if (payload.isSync()) {
                        ctx.reply(new ResponsePluginToRuleMsg(msg.getUid(), tenantId, ruleId,
                                BasicStatusCodeResponse.onError(payload.getMsgType(), payload.getRequestId(), new Exception(e))));
                    }
                }
            });
        } catch (MqttException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
