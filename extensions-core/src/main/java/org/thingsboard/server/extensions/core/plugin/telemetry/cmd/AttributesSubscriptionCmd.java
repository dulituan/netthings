/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.telemetry.cmd;

import lombok.NoArgsConstructor;
import org.thingsboard.server.extensions.core.plugin.telemetry.sub.SubscriptionType;

/**
 * @author Andrew Shvayka
 */
@NoArgsConstructor
public class AttributesSubscriptionCmd extends SubscriptionCmd {

    @Override
    public SubscriptionType getType() {
        return SubscriptionType.ATTRIBUTES;
    }

}
