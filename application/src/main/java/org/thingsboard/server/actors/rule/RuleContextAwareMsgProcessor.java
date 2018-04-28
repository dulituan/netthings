/**
 *
 */
package org.thingsboard.server.actors.rule;

import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.shared.AbstractContextAwareMsgProcessor;
import org.thingsboard.server.common.data.id.RuleId;

import akka.event.LoggingAdapter;

public class RuleContextAwareMsgProcessor extends AbstractContextAwareMsgProcessor {

    private final RuleId ruleId;
    
    protected RuleContextAwareMsgProcessor(ActorSystemContext systemContext, LoggingAdapter logger, RuleId ruleId) {
        super(systemContext, logger);
        this.ruleId = ruleId;
    }

}
