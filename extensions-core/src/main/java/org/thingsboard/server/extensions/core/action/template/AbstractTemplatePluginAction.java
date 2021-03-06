/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.action.template;

import lombok.extern.slf4j.Slf4j;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.runtime.parser.ParseException;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;
import org.thingsboard.server.extensions.api.plugins.PluginAction;
import org.thingsboard.server.extensions.api.plugins.msg.PluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.ResponsePluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.api.rules.RuleProcessingMetaData;
import org.thingsboard.server.extensions.api.rules.SimpleRuleLifecycleComponent;
import org.thingsboard.server.extensions.core.utils.VelocityUtils;

import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
@Slf4j
public abstract class AbstractTemplatePluginAction<T extends TemplateActionConfiguration> extends SimpleRuleLifecycleComponent implements PluginAction<T> {
    protected T configuration;
    protected Template template;

    @Override
    public void init(T configuration) {
        this.configuration = configuration;
        try {
            this.template = VelocityUtils.create(configuration.getTemplate(), "Template");
        } catch (ParseException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override
    public Optional<RuleToPluginMsg> convert(RuleContext ctx, ToDeviceActorMsg msg, RuleProcessingMetaData deviceMsgMd) {
        FromDeviceRequestMsg payload;
        if (msg.getPayload() instanceof FromDeviceRequestMsg) {
            payload = (FromDeviceRequestMsg) msg.getPayload();
        } else {
            throw new IllegalArgumentException("Action does not support messages of type: " + msg.getPayload().getMsgType());
        }
        return buildRuleToPluginMsg(ctx, msg, payload);
    }

    @Override
    public Optional<ToDeviceMsg> convert(PluginToRuleMsg<?> response) {
        if (response instanceof ResponsePluginToRuleMsg) {
            return Optional.of(((ResponsePluginToRuleMsg) response).getPayload());
        }
        return Optional.empty();
    }

    protected String getMsgBody(RuleContext ctx, ToDeviceActorMsg msg) {
        log.trace("Creating context for: {} and payload {}", ctx.getDeviceMetaData(), msg.getPayload());
        VelocityContext context = VelocityUtils.createContext(ctx.getDeviceMetaData(), msg.getPayload());
        return VelocityUtils.merge(template, context);
    }

    abstract protected Optional<RuleToPluginMsg> buildRuleToPluginMsg(RuleContext ctx,
                                                                         ToDeviceActorMsg msg,
                                                                         FromDeviceRequestMsg payload);

    @Override
    public boolean isOneWayAction() {
        return !configuration.isSync();
    }
}
