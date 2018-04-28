/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.ToServerRpcRequestMsg;

public class RpcRequestRuleToPluginMsg extends AbstractRuleToPluginMsg<ToServerRpcRequestMsg> {

    private static final long serialVersionUID = 1L;

    public RpcRequestRuleToPluginMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, ToServerRpcRequestMsg payload) {
        super(tenantId, customerId, deviceId, payload);
    }

}
