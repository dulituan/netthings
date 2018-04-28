/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sqs.action.standard;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

/**
 * Created by Valerii Sosliuk on 11/6/2017.
 */
@Data
public class SqsStandardQueuePluginActionConfiguration implements TemplateActionConfiguration {

    private String queue;
    private int delaySeconds;
    private boolean sync;
    private String template;

}
