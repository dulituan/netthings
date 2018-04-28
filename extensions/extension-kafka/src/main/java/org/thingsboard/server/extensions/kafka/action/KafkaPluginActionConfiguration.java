/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.kafka.action;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

@Data
public class KafkaPluginActionConfiguration implements TemplateActionConfiguration {
    private boolean sync;
    private String topic;
    private String template;
}
