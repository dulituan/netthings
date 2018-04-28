/**
 *
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
@Filter(name = "Method Name Filter", descriptor = "MethodNameFilterDescriptor.json", configuration = MethodNameFilterConfiguration.class)
@Slf4j
public class MethodNameFilter extends SimpleRuleLifecycleComponent implements RuleFilter<MethodNameFilterConfiguration> {

    private Set<String> methods;

    @Override
    public void init(MethodNameFilterConfiguration configuration) {
        methods = Arrays.stream(configuration.getMethodNames())
                .map(m -> m.getName())
                .collect(Collectors.toSet());
    }

    @Override
    public boolean filter(RuleContext ctx, ToDeviceActorMsg msg) {
        if (msg.getPayload().getMsgType() == TO_SERVER_RPC_REQUEST) {
            return methods.contains(((ToServerRpcRequestMsg) msg.getPayload()).getMethod());
        } else {
            return false;
        }
    }
}
