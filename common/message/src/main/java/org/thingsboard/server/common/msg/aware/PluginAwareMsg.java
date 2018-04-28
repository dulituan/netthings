/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.aware;

import org.thingsboard.server.common.data.id.PluginId;

public interface PluginAwareMsg {

    PluginId getPluginId();
    
}
