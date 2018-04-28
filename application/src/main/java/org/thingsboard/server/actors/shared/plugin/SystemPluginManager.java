/**
 *
 */
package org.thingsboard.server.actors.shared.plugin;

import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.service.DefaultActorService;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;
import org.thingsboard.server.common.data.plugin.PluginMetaData;
import org.thingsboard.server.dao.plugin.BasePluginService;

public class SystemPluginManager extends PluginManager {

    public SystemPluginManager(ActorSystemContext systemContext) {
        super(systemContext);
    }

    @Override
    FetchFunction<PluginMetaData> getFetchPluginsFunction() {
        return pluginService::findSystemPlugins;
    }

    @Override
    TenantId getTenantId() {
        return BasePluginService.SYSTEM_TENANT;
    }

    @Override
    protected String getDispatcherName() {
        return DefaultActorService.SYSTEM_PLUGIN_DISPATCHER_NAME;
    }
}
