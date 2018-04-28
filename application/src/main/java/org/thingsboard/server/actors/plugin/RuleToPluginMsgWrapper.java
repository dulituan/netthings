/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.plugin;

import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.aware.RuleAwareMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.plugins.msg.ToPluginActorMsg;

public class RuleToPluginMsgWrapper implements ToPluginActorMsg, RuleAwareMsg {

    private final TenantId pluginTenantId;
    private final PluginId pluginId;
    private final TenantId ruleTenantId;
    private final RuleId ruleId;
    private final RuleToPluginMsg<?> msg;

    public RuleToPluginMsgWrapper(TenantId pluginTenantId, PluginId pluginId, TenantId ruleTenantId, RuleId ruleId, RuleToPluginMsg<?> msg) {
        super();
        this.pluginTenantId = pluginTenantId;
        this.pluginId = pluginId;
        this.ruleTenantId = ruleTenantId;
        this.ruleId = ruleId;
        this.msg = msg;
    }

    @Override
    public TenantId getPluginTenantId() {
        return pluginTenantId;
    }

    @Override
    public PluginId getPluginId() {
        return pluginId;
    }

    public TenantId getRuleTenantId() {
        return ruleTenantId;
    }

    @Override
    public RuleId getRuleId() {
        return ruleId;
    }


    public RuleToPluginMsg getMsg() {
        return msg;
    }

}
