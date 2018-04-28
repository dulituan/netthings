/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sqs.action.fifo;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

/**
 * Created by Valerii Sosliuk on 11/10/2017.
 */
public class SqsFifoQueueActionMsg extends AbstractRuleToPluginMsg<SqsFifoQueueActionPayload> {

    public SqsFifoQueueActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, SqsFifoQueueActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
