/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.core.TelemetryUploadRequest;

public class TelemetryUploadRequestRuleToPluginMsg extends AbstractRuleToPluginMsg<TelemetryUploadRequest> {

    private static final long serialVersionUID = 1L;
    private final long ttl;

    public TelemetryUploadRequestRuleToPluginMsg(TenantId tenantId, CustomerId customerId, DeviceId deviceId, TelemetryUploadRequest payload, long ttl) {
        super(tenantId, customerId, deviceId, payload);
        this.ttl = ttl;
    }

    public long getTtl() {
        return ttl;
    }
}
