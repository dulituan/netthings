/**
 *
 */
package org.thingsboard.server.extensions.rest.action;

import lombok.Data;
import org.thingsboard.server.extensions.core.action.template.TemplateActionConfiguration;

@Data
public class RestApiCallPluginActionConfiguration implements TemplateActionConfiguration {
    private boolean sync;
    private String template;
    private String actionPath;
    private int expectedResultCode;
    private String requestMethod;
}
