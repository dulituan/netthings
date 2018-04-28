/**
 *
 */
package org.thingsboard.server.dao.plugin;

import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TextPageLink;
import org.thingsboard.server.common.data.plugin.PluginMetaData;
import org.thingsboard.server.dao.Dao;

import java.util.List;
import java.util.UUID;

public interface PluginDao extends Dao<PluginMetaData> {

    PluginMetaData save(PluginMetaData plugin);

    PluginMetaData findById(PluginId pluginId);

    PluginMetaData findByApiToken(String apiToken);

    void deleteById(UUID id);

    void deleteById(PluginId pluginId);

    List<PluginMetaData> findByTenantIdAndPageLink(TenantId tenantId, TextPageLink pageLink);

    /**
     * Find all tenant plugins (including system) by tenantId and page link.
     *
     * @param tenantId the tenantId
     * @param pageLink the page link
     * @return the list of plugins objects
     */
    List<PluginMetaData> findAllTenantPluginsByTenantId(UUID tenantId, TextPageLink pageLink);

}
