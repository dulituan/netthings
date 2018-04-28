/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;

import java.io.Serializable;
import java.util.UUID;

/**
 * The basic interface for messages that are sent from particular rule to plugin
 * instance
 * 
 * @author ashvayka
 *
 */
public interface RuleToPluginMsg<V extends Serializable> extends Serializable {
    
    /**
     * Returns the unique identifier of the message
     * 
     * @return unique identifier of the message.
     */
    UUID getUid();

    
    /**
     * Returns the unique identifier of the device that send the message
     * 
     * @return unique identifier of the device.
     */
    DeviceId getDeviceId();

    /**
     * Returns the unique identifier of the customer that owns the device
     *
     * @return unique identifier of the device.
     */
    CustomerId getCustomerId();

    /**
     * Returns the serializable message payload.
     * 
     * @return the serializable message payload.
     */
    V getPayload();
}
