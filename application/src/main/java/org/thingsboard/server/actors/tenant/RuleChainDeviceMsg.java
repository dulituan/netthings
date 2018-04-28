/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.tenant;

import org.thingsboard.server.actors.rule.RuleActorChain;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;

public class RuleChainDeviceMsg {

    private final ToDeviceActorMsg toDeviceActorMsg;
    private final RuleActorChain ruleChain;

    public RuleChainDeviceMsg(ToDeviceActorMsg toDeviceActorMsg, RuleActorChain ruleChain) {
        super();
        this.toDeviceActorMsg = toDeviceActorMsg;
        this.ruleChain = ruleChain;
    }

    public ToDeviceActorMsg getToDeviceActorMsg() {
        return toDeviceActorMsg;
    }

    public RuleActorChain getRuleChain() {
        return ruleChain;
    }

}
