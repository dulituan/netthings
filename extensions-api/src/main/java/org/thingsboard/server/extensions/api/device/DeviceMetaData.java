/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.device;

import lombok.Data;
import org.thingsboard.server.common.data.id.DeviceId;

/**
 * Contains basic device metadata;
 *
 * @author ashvayka
 */
@Data
public final class DeviceMetaData {

    final DeviceId deviceId;
    final String deviceName;
    final String deviceType;
    final DeviceAttributes deviceAttributes;

}
