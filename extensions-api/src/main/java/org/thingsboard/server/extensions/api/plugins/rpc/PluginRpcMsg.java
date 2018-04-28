/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.rpc;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.ToPluginActorMsg;

@ToString
@RequiredArgsConstructor
public class PluginRpcMsg implements ToPluginActorMsg {

    private final TenantId tenantId;
    private final PluginId pluginId;
    @Getter
    private final RpcMsg rpcMsg;

    @Override
    public TenantId getPluginTenantId() {
        return tenantId;
    }

    @Override
    public PluginId getPluginId() {
        return pluginId;
    }



}
