/**
 *
 */
package org.thingsboard.server.extensions.sns.action;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

/**
 * Created by Valerii Sosliuk on 11/15/2017.
 */
@Data
public class SnsTopicPluginActionConfiguration implements TemplateActionConfiguration {

    private String topicArn;
    private String template;
    private boolean sync;
}
