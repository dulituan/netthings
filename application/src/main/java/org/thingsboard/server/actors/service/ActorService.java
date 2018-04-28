/**
 *
 */
package org.thingsboard.server.actors.service;

import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleEvent;
import org.thingsboard.server.common.transport.SessionMsgProcessor;
import org.thingsboard.server.service.cluster.discovery.DiscoveryServiceListener;
import org.thingsboard.server.service.cluster.rpc.RpcMsgListener;

public interface ActorService extends SessionMsgProcessor, WebSocketMsgProcessor, RestMsgProcessor, RpcMsgListener, DiscoveryServiceListener {

    void onPluginStateChange(TenantId tenantId, PluginId pluginId, ComponentLifecycleEvent state);

    void onRuleStateChange(TenantId tenantId, RuleId ruleId, ComponentLifecycleEvent state);

    void onCredentialsUpdate(TenantId tenantId, DeviceId deviceId);

    void onDeviceNameOrTypeUpdate(TenantId tenantId, DeviceId deviceId, String deviceName, String deviceType);
}
