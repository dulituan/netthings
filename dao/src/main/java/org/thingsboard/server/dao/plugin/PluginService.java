/**
 *
 */
package org.thingsboard.server.dao.plugin;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TextPageData;
import org.thingsboard.server.common.data.page.TextPageLink;
import org.thingsboard.server.common.data.plugin.PluginMetaData;

import java.util.List;

public interface PluginService {

    PluginMetaData savePlugin(PluginMetaData plugin);

    PluginMetaData findPluginById(PluginId pluginId);

    ListenableFuture<PluginMetaData> findPluginByIdAsync(PluginId pluginId);

    PluginMetaData findPluginByApiToken(String apiToken);

    TextPageData<PluginMetaData> findSystemPlugins(TextPageLink pageLink);

    TextPageData<PluginMetaData> findTenantPlugins(TenantId tenantId, TextPageLink pageLink);

    List<PluginMetaData> findSystemPlugins();

    TextPageData<PluginMetaData> findAllTenantPluginsByTenantIdAndPageLink(TenantId tenantId, TextPageLink pageLink);

    List<PluginMetaData> findAllTenantPluginsByTenantId(TenantId tenantId);

    void activatePluginById(PluginId pluginId);

    void suspendPluginById(PluginId pluginId);

    void deletePluginById(PluginId pluginId);

    void deletePluginsByTenantId(TenantId tenantId);

}
