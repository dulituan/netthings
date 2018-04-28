/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.rules;

import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.msg.aware.TenantAwareMsg;

public interface ToRuleActorMsg extends TenantAwareMsg {

    RuleId getRuleId();
    
}
