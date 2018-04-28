/**
 *
 */
package org.thingsboard.server.extensions.api.device;

import lombok.Data;
import lombok.Getter;
import lombok.ToString;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.kv.AttributeKey;

import java.util.Set;

/**
 * @author Andrew Shvayka
 */
@Data
public class DeviceCredentialsUpdateNotificationMsg implements ToDeviceActorNotificationMsg {

    private final TenantId tenantId;
    private final DeviceId deviceId;

}
