/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.plugin;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleState;
import org.thingsboard.server.common.msg.aware.TenantAwareMsg;
import org.thingsboard.server.common.msg.cluster.ToAllNodesMsg;

import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
@ToString
public class ComponentLifecycleMsg implements TenantAwareMsg, ToAllNodesMsg {
    @Getter
    private final TenantId tenantId;
    private final PluginId pluginId;
    private final RuleId ruleId;
    @Getter
    private final ComponentLifecycleEvent event;

    public static ComponentLifecycleMsg forPlugin(TenantId tenantId, PluginId pluginId, ComponentLifecycleEvent event) {
        return new ComponentLifecycleMsg(tenantId, pluginId, null, event);
    }

    public static ComponentLifecycleMsg forRule(TenantId tenantId, RuleId ruleId, ComponentLifecycleEvent event) {
        return new ComponentLifecycleMsg(tenantId, null, ruleId, event);
    }

    private ComponentLifecycleMsg(TenantId tenantId, PluginId pluginId, RuleId ruleId, ComponentLifecycleEvent event) {
        this.tenantId = tenantId;
        this.pluginId = pluginId;
        this.ruleId = ruleId;
        this.event = event;
    }

    public Optional<PluginId> getPluginId() {
        return Optional.ofNullable(pluginId);
    }

    public Optional<RuleId> getRuleId() {
        return Optional.ofNullable(ruleId);
    }
}
