/**
 *
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.msg.core.UpdateAttributesRequest;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.extensions.api.component.Filter;
import org.thingsboard.server.extensions.api.device.DeviceAttributes;
import org.thingsboard.server.extensions.api.rules.RuleContext;

import javax.script.Bindings;
import javax.script.ScriptException;

/**
 * @author Andrew Shvayka
 */
@Filter(name = "Device Attributes Filter", descriptor = "JsFilterDescriptor.json", configuration = JsFilterConfiguration.class)
@Slf4j
public class DeviceAttributesFilter extends BasicJsFilter {

    @Override
    protected boolean doFilter(RuleContext ctx, ToDeviceActorMsg msg) throws ScriptException {
        return evaluator.execute(toBindings(ctx.getDeviceMetaData().getDeviceAttributes(), msg != null ? msg.getPayload() : null));
    }

    private Bindings toBindings(DeviceAttributes attributes, FromDeviceMsg msg) {
        Bindings bindings = NashornJsEvaluator.getAttributeBindings(attributes);

        if (msg != null) {
            switch (msg.getMsgType()) {
                case POST_ATTRIBUTES_REQUEST:
                    bindings = NashornJsEvaluator.updateBindings(bindings, (UpdateAttributesRequest) msg);
                    break;
                default:
                    break;
            }
        }

        return bindings;
    }

}
