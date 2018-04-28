/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.GetAttributesRequest;

/**
 * @author Andrew Shvayka
 */
public class GetAttributesRequestRuleToPluginMsg extends AbstractRuleToPluginMsg<GetAttributesRequest> {

    private static final long serialVersionUID = 1L;

    public GetAttributesRequestRuleToPluginMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, GetAttributesRequest payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
