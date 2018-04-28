/**
 *
 */
package org.thingsboard.server.extensions.sqs.action.standard;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

/**
 * Created by Valerii Sosliuk on 11/6/2017.
 */
public class SqsStandardQueueActionMsg extends AbstractRuleToPluginMsg<SqsStandardQueueActionPayload> {

    public SqsStandardQueueActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, SqsStandardQueueActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
