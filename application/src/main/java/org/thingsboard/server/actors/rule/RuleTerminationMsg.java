/**
 *
 */
package org.thingsboard.server.actors.rule;

import org.thingsboard.server.actors.shared.ActorTerminationMsg;
import org.thingsboard.server.common.data.id.PluginId;
import org.thingsboard.server.common.data.id.RuleId;

/**
 * @author Andrew Shvayka
 */
public class RuleTerminationMsg extends ActorTerminationMsg<RuleId> {

    public RuleTerminationMsg(RuleId id) {
        super(id);
    }
}
