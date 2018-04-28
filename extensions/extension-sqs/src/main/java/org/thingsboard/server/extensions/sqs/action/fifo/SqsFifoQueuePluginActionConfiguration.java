/**
 *
 */
package org.thingsboard.server.extensions.sqs.action.fifo;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

/**
 * Created by Valerii Sosliuk on 11/10/2017.
 */
@Data
public class SqsFifoQueuePluginActionConfiguration implements TemplateActionConfiguration {

    private String queue;
    private String template;
    private boolean sync;
}
