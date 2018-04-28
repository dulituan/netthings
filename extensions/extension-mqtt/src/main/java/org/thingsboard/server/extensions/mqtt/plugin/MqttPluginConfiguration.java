/**
 *
 */
package org.thingsboard.server.extensions.mqtt.plugin;

import lombok.Data;

@Data
public class MqttPluginConfiguration {
    private String host;
    private int port;
    private int maxInFlight;
    private int retryInterval;
    private String clientId;
    private String accessToken;
}