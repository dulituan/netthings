/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.transport.mqtt.adaptors;

import io.netty.handler.codec.mqtt.MqttMessage;
import org.thingsboard.server.common.transport.TransportAdaptor;
import org.thingsboard.server.transport.mqtt.session.DeviceSessionCtx;

/**
 * @author Andrew Shvayka
 */
public interface MqttTransportAdaptor extends TransportAdaptor<DeviceSessionCtx, MqttMessage, MqttMessage> {
}
