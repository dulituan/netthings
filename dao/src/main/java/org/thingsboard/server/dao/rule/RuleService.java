/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.rule;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TextPageData;
import org.thingsboard.server.common.data.page.TextPageLink;
import org.thingsboard.server.common.data.rule.RuleMetaData;

import java.util.List;

public interface RuleService {

    RuleMetaData saveRule(RuleMetaData device);

    RuleMetaData findRuleById(RuleId ruleId);

    ListenableFuture<RuleMetaData> findRuleByIdAsync(RuleId ruleId);

    List<RuleMetaData> findPluginRules(String pluginToken);

    TextPageData<RuleMetaData> findSystemRules(TextPageLink pageLink);

    TextPageData<RuleMetaData> findTenantRules(TenantId tenantId, TextPageLink pageLink);

    List<RuleMetaData> findSystemRules();

    TextPageData<RuleMetaData> findAllTenantRulesByTenantIdAndPageLink(TenantId tenantId, TextPageLink pageLink);

    List<RuleMetaData> findAllTenantRulesByTenantId(TenantId tenantId);

    void activateRuleById(RuleId ruleId);

    void suspendRuleById(RuleId ruleId);

    void deleteRuleById(RuleId ruleId);

    void deleteRulesByTenantId(TenantId tenantId);

}
