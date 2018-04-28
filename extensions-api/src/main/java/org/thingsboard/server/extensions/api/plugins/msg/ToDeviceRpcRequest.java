/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import lombok.Data;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.PluginApiCallSecurityContext;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToDeviceRpcRequest implements Serializable {
    private final UUID id;
    private final PluginApiCallSecurityContext securityCtx;
    private final TenantId tenantId;
    private final DeviceId deviceId;
    private final boolean oneway;
    private final long expirationTime;
    private final ToDeviceRpcRequestBody body;
}

