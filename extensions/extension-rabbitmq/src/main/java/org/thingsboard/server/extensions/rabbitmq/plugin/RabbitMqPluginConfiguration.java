/**
 *
 */
package org.thingsboard.server.extensions.rabbitmq.plugin;

import lombok.Data;

import java.util.List;

/**
 * @author Andrew Shvayka
 */
@Data
public class RabbitMqPluginConfiguration {
    private String host;
    private int port;
    private String virtualHost;

    private String userName;
    private String password;

    private Boolean automaticRecoveryEnabled;

    private Integer connectionTimeout;
    private Integer handshakeTimeout;

    private List<RabbitMqPluginProperties> clientProperties;

    @Data
    public static class RabbitMqPluginProperties {
        private String key;
        private String value;
    }

}
