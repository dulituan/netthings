/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.msg.core.ToServerRpcRequestMsg;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.extensions.api.component.Filter;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.api.rules.RuleFilter;
import org.thingsboard.server.extensions.api.rules.SimpleRuleLifecycleComponent;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import static org.thingsboard.server.common.msg.session.MsgType.TO_SERVER_RPC_REQUEST;

/**
 * @author Andrew Shvayka
 */
@Filter(name = "Device Type Filter", descriptor = "DeviceTypeFilterDescriptor.json", configuration = DeviceTypeFilterConfiguration.class)
@Slf4j
public class DeviceTypeFilter extends SimpleRuleLifecycleComponent implements RuleFilter<DeviceTypeFilterConfiguration> {

    private Set<String> deviceTypes;

    @Override
    public void init(DeviceTypeFilterConfiguration configuration) {
        deviceTypes = Arrays.stream(configuration.getDeviceTypes())
                .map(m -> m.getName())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean filter(RuleContext ctx, ToDeviceActorMsg msg) {
        return deviceTypes.contains(ctx.getDeviceMetaData().getDeviceType());
    }
}
