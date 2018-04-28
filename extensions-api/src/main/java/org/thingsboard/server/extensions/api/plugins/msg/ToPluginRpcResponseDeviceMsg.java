/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import lombok.Data;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToPluginRpcResponseDeviceMsg implements ToPluginActorMsg {
    private final PluginId pluginId;
    private final TenantId pluginTenantId;
    private final FromDeviceRpcResponse response;
}

