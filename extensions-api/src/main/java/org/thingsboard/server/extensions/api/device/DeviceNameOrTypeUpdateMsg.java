/**
 *
 */
package org.thingsboard.server.extensions.api.device;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

@Data
@AllArgsConstructor
public class DeviceNameOrTypeUpdateMsg implements ToDeviceActorNotificationMsg {
    private final TenantId tenantId;
    private final DeviceId deviceId;
    private final String deviceName;
    private final String deviceType;
}
