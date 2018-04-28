/**
 *
 */
package org.thingsboard.server.actors.shared.plugin;

import akka.actor.ActorContext;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.service.DefaultActorService;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.PageDataIterable.FetchFunction;
import org.thingsboard.server.common.data.plugin.PluginMetaData;

public class TenantPluginManager extends PluginManager {

    private final TenantId tenantId;

    public TenantPluginManager(ActorSystemContext systemContext, TenantId tenantId) {
        super(systemContext);
        this.tenantId = tenantId;
    }

    @Override
    public void init(ActorContext context) {
        if (systemContext.isTenantComponentsInitEnabled()) {
            super.init(context);
        }
    }

    @Override
    FetchFunction<PluginMetaData> getFetchPluginsFunction() {
        return link -> pluginService.findTenantPlugins(tenantId, link);
    }

    @Override
    TenantId getTenantId() {
        return tenantId;
    }

    @Override
    protected String getDispatcherName() {
        return DefaultActorService.TENANT_PLUGIN_DISPATCHER_NAME;
    }

}
