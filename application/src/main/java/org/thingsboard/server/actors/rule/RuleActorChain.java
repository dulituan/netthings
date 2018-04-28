/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.rule;

public interface RuleActorChain {

    int size();

    RuleActorMetaData getRuleActorMd(int index);

}
