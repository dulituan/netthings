/**
 *
 */
package org.thingsboard.server.actors.device;

import lombok.Data;
import org.thingsboard.server.extensions.api.plugins.msg.ToDeviceRpcRequestPluginMsg;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToDeviceRpcRequestMetadata {
    private final ToDeviceRpcRequestPluginMsg msg;
    private final boolean sent;
}
