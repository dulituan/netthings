/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.extensions.api.device.ToDeviceActorNotificationMsg;

import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
@ToString
@RequiredArgsConstructor
public class ToDeviceRpcRequestPluginMsg implements ToDeviceActorNotificationMsg {

    private final ServerAddress serverAddress;
    @Getter
    private final PluginId pluginId;
    @Getter
    private final TenantId pluginTenantId;
    @Getter
    private final ToDeviceRpcRequest msg;

    public ToDeviceRpcRequestPluginMsg(PluginId pluginId, TenantId pluginTenantId, ToDeviceRpcRequest msg) {
        this(null, pluginId, pluginTenantId, msg);
    }

    public Optional<ServerAddress> getServerAddress() {
        return Optional.ofNullable(serverAddress);
    }

    @Override
    public DeviceId getDeviceId() {
        return msg.getDeviceId();
    }

    @Override
    public TenantId getTenantId() {
        return msg.getTenantId();
    }
}

