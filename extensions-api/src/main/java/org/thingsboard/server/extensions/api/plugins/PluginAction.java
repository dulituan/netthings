/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins;

import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.ToDeviceMsg;
import org.thingsboard.server.extensions.api.component.ConfigurableComponent;
import org.thingsboard.server.extensions.api.plugins.msg.PluginToRuleMsg;
import org.thingsboard.server.extensions.api.plugins.msg.RuleToPluginMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.api.rules.RuleLifecycleComponent;
import org.thingsboard.server.extensions.api.rules.RuleProcessingMetaData;

import java.util.Optional;

public interface PluginAction<T> extends ConfigurableComponent<T>, RuleLifecycleComponent {

    Optional<RuleToPluginMsg> convert(RuleContext ctx, ToDeviceActorMsg toDeviceActorMsg, RuleProcessingMetaData deviceMsgMd);

    Optional<ToDeviceMsg> convert(PluginToRuleMsg<?> response);

    boolean isOneWayAction();

}
