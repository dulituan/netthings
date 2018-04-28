/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.rest.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.extensions.api.component.Action;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.core.action.template.AbstractTemplatePluginAction;

import java.util.Optional;

@Action(name = "REST API Call Plugin Action",
        descriptor = "RestApiCallActionDescriptor.json", configuration = RestApiCallPluginActionConfiguration.class)
@Slf4j
public class RestApiCallPluginAction extends AbstractTemplatePluginAction<RestApiCallPluginActionConfiguration> {

    @Override
    protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx, ToDeviceActorMsg msg, FromDeviceRequestMsg payload) {
        RestApiCallActionPayload.RestApiCallActionPayloadBuilder builder = RestApiCallActionPayload.builder();
        builder.msgType(payload.getMsgType());
        builder.requestId(payload.getRequestId());
        builder.sync(configuration.isSync());
        builder.actionPath(configuration.getActionPath());
        builder.httpMethod(HttpMethod.valueOf(configuration.getRequestMethod()));
        builder.expectedResultCode(HttpStatus.valueOf(configuration.getExpectedResultCode()));
        builder.msgBody(getMsgBody(ctx, msg));
        return Optional.of(new RestApiCallActionMsg(msg.getTenantId(),
                msg.getCustomerId(),
                msg.getDeviceId(),
                builder.build()));
    }

}
