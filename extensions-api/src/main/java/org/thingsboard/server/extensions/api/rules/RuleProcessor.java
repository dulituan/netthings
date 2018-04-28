/**
 *
 */
package org.thingsboard.server.extensions.api.rules;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.extensions.api.component.ConfigurableComponent;

import javax.script.ScriptException;

/**
 * @author Andrew Shvayka
 */
public interface RuleProcessor<T> extends ConfigurableComponent<T>, RuleLifecycleComponent {

    RuleProcessingMetaData process(RuleContext ctx, ToDeviceActorMsg msg) throws RuleException;
}
