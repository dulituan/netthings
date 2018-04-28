/**
 *
 */
package org.thingsboard.server.extensions.core.action.mail;

import lombok.Data;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.extensions.api.plugins.msg.AbstractRuleToPluginMsg;

/**
 * @author Andrew Shvayka
 */
@Data
public class SendMailRuleToPluginActionMsg extends AbstractRuleToPluginMsg<SendMailActionMsg> {

    public SendMailRuleToPluginActionMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId,
                                     SendMailActionMsg payload) {
        super(tenantId, customerId, deviceId, payload);
    }

}
