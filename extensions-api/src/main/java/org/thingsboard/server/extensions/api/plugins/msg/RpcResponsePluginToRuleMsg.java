/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.ToServerRpcResponseMsg;

import java.util.UUID;

public class RpcResponsePluginToRuleMsg extends AbstractPluginToRuleMsg<ToServerRpcResponseMsg> {

    private static final long serialVersionUID = 1L;

    public RpcResponsePluginToRuleMsg(UUID uid, TenantId tenantId, RuleId ruleId, ToServerRpcResponseMsg payload) {
        super(uid, tenantId, ruleId, payload);
    }

}
