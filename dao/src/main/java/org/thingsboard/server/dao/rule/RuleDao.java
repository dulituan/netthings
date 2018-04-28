/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.rule;

import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TextPageLink;
import org.thingsboard.server.common.data.rule.RuleMetaData;
import org.thingsboard.server.dao.Dao;

import java.util.List;
import java.util.UUID;

public interface RuleDao extends Dao<RuleMetaData> {

    RuleMetaData save(RuleMetaData rule);

    RuleMetaData findById(RuleId ruleId);

    List<RuleMetaData> findRulesByPlugin(String pluginToken);

    List<RuleMetaData> findByTenantIdAndPageLink(TenantId tenantId, TextPageLink pageLink);

    /**
     * Find all tenant rules (including system) by tenantId and page link.
     *
     * @param tenantId the tenantId
     * @param pageLink the page link
     * @return the list of rules objects
     */
    List<RuleMetaData> findAllTenantRulesByTenantId(UUID tenantId, TextPageLink pageLink);

    void deleteById(UUID id);

    void deleteById(RuleId ruleId);
}
