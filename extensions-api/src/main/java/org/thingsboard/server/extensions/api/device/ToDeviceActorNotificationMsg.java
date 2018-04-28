/**
 *
 */
package org.thingsboard.server.extensions.api.device;

import org.thingsboard.server.common.msg.aware.DeviceAwareMsg;
import org.thingsboard.server.common.msg.aware.TenantAwareMsg;

import java.io.Serializable;

/**
 * @author Andrew Shvayka
 */
public interface ToDeviceActorNotificationMsg extends TenantAwareMsg, DeviceAwareMsg, Serializable {

}
