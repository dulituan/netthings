/**
 *
 */
package org.thingsboard.server.extensions.api.rules;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.extensions.api.component.ConfigurableComponent;

/**
 * @author Andrew Shvayka
 */
public interface RuleFilter<T> extends ConfigurableComponent<T>, RuleLifecycleComponent {

    boolean filter(RuleContext ctx, ToDeviceActorMsg msg);
    
}
