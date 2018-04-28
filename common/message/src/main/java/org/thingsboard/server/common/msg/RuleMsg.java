/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg;

import org.thingsboard.server.common.data.rule.Scope;
import org.thingsboard.server.common.data.rule.RuleType;
import org.thingsboard.server.common.msg.aware.RuleAwareMsg;

/**
 * Message that is used to deliver some data to the rule instance. 
 * For example: aggregated statistics or command decoded from http request. 
 * 
 * @author ashvayka
 *
 * @param <V> - payload 
 */
public interface RuleMsg<V> extends RuleAwareMsg {

	Scope getRuleLevel();
	
	RuleType getRuleType();
	
	V getPayload();
	
}
