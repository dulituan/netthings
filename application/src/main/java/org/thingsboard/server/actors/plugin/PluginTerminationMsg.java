/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.plugin;

import org.thingsboard.server.actors.shared.ActorTerminationMsg;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.SessionId;

/**
 * @author Andrew Shvayka
 */
public class PluginTerminationMsg extends ActorTerminationMsg<PluginId> {

    public PluginTerminationMsg(PluginId id) {
        super(id);
    }
}
