/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.messaging;

import lombok.Data;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;

import java.util.UUID;

/**
 * @author Andrew Shvayka
 */
@Data
class PendingRpcRequestMetadata {
    private final UUID uid;
    private final int requestId;
    private final TenantId tenantId;
    private final RuleId ruleId;
    private final CustomerId customerId;
    private final DeviceId deviceId;
}
