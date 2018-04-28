/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.messaging;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class DeviceMessagingPluginConfiguration {

    private int maxDeviceCountPerCustomer;
    private long defaultTimeout;
    private long maxTimeout;

}
