/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.shared.rule;

import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.service.DefaultActorService;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;
import org.thingsboard.server.common.data.rule.RuleMetaData;
import org.thingsboard.server.dao.model.ModelConstants;

public class SystemRuleManager extends RuleManager {

    public SystemRuleManager(ActorSystemContext systemContext) {
        super(systemContext, new TenantId(ModelConstants.NULL_UUID));
    }

    @Override
    FetchFunction<RuleMetaData> getFetchRulesFunction() {
        return ruleService::findSystemRules;
    }

    @Override
    String getDispatcherName() {
        return DefaultActorService.SYSTEM_RULE_DISPATCHER_NAME;
    }
}
