/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.aware.PluginAwareMsg;

public interface ToPluginActorMsg extends PluginAwareMsg {

    TenantId getPluginTenantId();

}
