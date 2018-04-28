/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sns.action;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

/**
 * Created by Valerii Sosliuk on 11/15/2017.
 */
public class SnsTopicActionMsg extends AbstractRuleToPluginMsg<SnsTopicActionPayload> {

    public SnsTopicActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, SnsTopicActionPayload payload) {
        super(tenantId, customerId, deviceId, payload);
    }
}
