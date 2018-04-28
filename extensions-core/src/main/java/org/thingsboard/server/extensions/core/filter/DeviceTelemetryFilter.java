/**
 *
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.msg.core.TelemetryUploadRequest;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.extensions.api.component.Filter;
import org.thingsboard.server.extensions.api.rules.RuleContext;

import javax.script.ScriptException;
import java.util.List;

/**
 * @author Andrew Shvayka
 */
@Filter(name = "Device Telemetry Filter", descriptor = "JsFilterDescriptor.json", configuration = JsFilterConfiguration.class)
@Slf4j
public class DeviceTelemetryFilter extends BasicJsFilter {

    @Override
    protected boolean doFilter(RuleContext ctx, ToDeviceActorMsg msg) throws ScriptException {
        FromDeviceMsg deviceMsg = msg.getPayload();
        if (deviceMsg instanceof TelemetryUploadRequest) {
            TelemetryUploadRequest telemetryMsg = (TelemetryUploadRequest) deviceMsg;
            for (List<KvEntry> entries : telemetryMsg.getData().values()) {
                if (evaluator.execute(NashornJsEvaluator.toBindings(entries))) {
                    return true;
                }
            }
        }
        return false;
    }

}
