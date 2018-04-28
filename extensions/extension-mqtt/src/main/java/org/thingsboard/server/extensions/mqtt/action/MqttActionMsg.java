/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.mqtt.action;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

public class MqttActionMsg extends AbstractRuleToPluginMsg<MqttActionPayload> {

    public MqttActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, MqttActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
