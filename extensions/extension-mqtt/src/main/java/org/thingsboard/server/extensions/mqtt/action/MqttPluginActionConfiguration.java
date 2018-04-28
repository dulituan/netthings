/**
 *
 */
package org.thingsboard.server.extensions.mqtt.action;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

@Data
public class MqttPluginActionConfiguration implements TemplateActionConfiguration {
    private boolean sync;
    private String topic;
    private String template;
}
