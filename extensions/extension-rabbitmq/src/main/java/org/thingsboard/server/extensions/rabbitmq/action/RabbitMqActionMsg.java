/**
 *
 */
package org.thingsboard.server.extensions.rabbitmq.action;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

/**
 * @author Andrew Shvayka
 */
public class RabbitMqActionMsg extends AbstractRuleToPluginMsg<RabbitMqActionPayload> {

    public RabbitMqActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, RabbitMqActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
