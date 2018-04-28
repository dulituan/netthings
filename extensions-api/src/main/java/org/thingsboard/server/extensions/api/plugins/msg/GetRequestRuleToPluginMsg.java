/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;

public class GetRequestRuleToPluginMsg extends AbstractRuleToPluginMsg<String[]>{

    private static final long serialVersionUID = 1L;

    public GetRequestRuleToPluginMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId,
            String[] payload) {
        super(tenantId, customerId, deviceId, payload);
    }

}
