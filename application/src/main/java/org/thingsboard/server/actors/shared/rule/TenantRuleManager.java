/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.shared.rule;

import akka.actor.ActorContext;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.service.DefaultActorService;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;
import org.thingsboard.server.common.data.rule.RuleMetaData;

public class TenantRuleManager extends RuleManager {
    
    public TenantRuleManager(ActorSystemContext systemContext, TenantId tenantId) {
        super(systemContext, tenantId);
    }

    @Override
    public void init(ActorContext context) {
        if (systemContext.isTenantComponentsInitEnabled()) {
            super.init(context);
        }
    }

    @Override
    FetchFunction<RuleMetaData> getFetchRulesFunction() {
        return link -> ruleService.findTenantRules(tenantId, link);
    }

    @Override
    String getDispatcherName() {
        return DefaultActorService.TENANT_RULE_DISPATCHER_NAME;
    }

}
