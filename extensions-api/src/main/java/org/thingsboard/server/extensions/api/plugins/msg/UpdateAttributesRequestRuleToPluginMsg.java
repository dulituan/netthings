/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.UpdateAttributesRequest;

public class UpdateAttributesRequestRuleToPluginMsg extends AbstractRuleToPluginMsg<UpdateAttributesRequest> {

    private static final long serialVersionUID = 1L;

    public UpdateAttributesRequestRuleToPluginMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, UpdateAttributesRequest payload) {
        super(tenantId, customerId, deviceId, payload);
    }

}
