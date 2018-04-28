/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sns.plugin;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.BasicStatusCodeResponse;
import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.handlers.RuleMsgHandler;
import org.thingsboard.server.extensions.api.plugins.msg.ResponsePluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleException;
import org.thingsboard.server.extensions.sns.action.SnsTopicActionMsg;
import org.thingsboard.server.extensions.sns.action.SnsTopicActionPayload;

/**
 * Created by Valerii Sosliuk on 11/6/2017.
 */
@RequiredArgsConstructor
@Slf4j
public class SnsMessageHandler implements RuleMsgHandler {

    private final AmazonSNS sns;

    @Override
    public void process(PluginContext ctx, TenantId tenantId, RuleId ruleId, RuleToPluginMsg<?> msg) throws RuleException {
        if (msg instanceof SnsTopicActionMsg) {
            SnsTopicActionPayload payload = ((SnsTopicActionMsg) msg).getPayload();
            PublishRequest publishRequest = new PublishRequest()
                    .withTopicArn(payload.getTopicArn())
                    .withMessage(payload.getMsgBody());
            sns.publish(publishRequest);
            if (payload.isSync()) {
                ctx.reply(new ResponsePluginToRuleMsg(msg.getUid(), tenantId, ruleId,
                        BasicStatusCodeResponse.onSuccess(payload.getMsgType(), payload.getRequestId())));
            }
           return;
        }
        throw new RuleException("Unsupported message type " + msg.getClass().getName() + "!");

    }

}
