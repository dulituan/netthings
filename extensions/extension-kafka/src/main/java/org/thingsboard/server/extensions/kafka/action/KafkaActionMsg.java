/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.kafka.action;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

public class KafkaActionMsg extends AbstractRuleToPluginMsg<KafkaActionPayload> {

    public KafkaActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, KafkaActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
