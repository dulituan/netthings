/**
 *
 */
package org.thingsboard.server.common.msg.aware;

import org.thingsboard.server.common.data.id.RuleId;

public interface RuleAwareMsg {

	RuleId getRuleId();
	
}
