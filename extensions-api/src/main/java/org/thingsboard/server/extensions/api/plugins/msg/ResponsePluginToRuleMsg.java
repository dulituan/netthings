/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;

import java.util.UUID;

public class ResponsePluginToRuleMsg extends AbstractPluginToRuleMsg<ToDeviceMsg>{

    private static final long serialVersionUID = 1L;

    public ResponsePluginToRuleMsg(UUID uid, TenantId tenantId, RuleId ruleId, ToDeviceMsg payload) {
        super(uid, tenantId, ruleId, payload);
    }

}
