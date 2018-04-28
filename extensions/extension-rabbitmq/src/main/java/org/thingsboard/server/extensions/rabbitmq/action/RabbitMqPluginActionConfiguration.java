/**
 *
 */
package org.thingsboard.server.extensions.rabbitmq.action;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

/**
 * @author Andrew Shvayka
 */
@Data
public class RabbitMqPluginActionConfiguration implements TemplateActionConfiguration{

    private boolean sync;
    private String exchange;
    private String queueName;
    private String messageProperties;
    private String template;
}
