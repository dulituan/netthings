/**
 *
 */
package org.thingsboard.server.extensions.rest.action;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

public class RestApiCallActionMsg extends AbstractRuleToPluginMsg<RestApiCallActionPayload> {

    public RestApiCallActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, RestApiCallActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
