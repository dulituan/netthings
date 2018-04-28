/**
 *
 */
package org.thingsboard.server.extensions.rest.plugin;

import lombok.Data;
import org.thingsboard.server.extensions.core.plugin.KeyValuePluginProperties;

import java.util.List;

@Data
public class RestApiCallPluginConfiguration {

    private String protocol;
    private String host;
    private int port;
    private String basePath;

    private String authMethod;

    private String userName;
    private String password;

    private List<KeyValuePluginProperties> headers;
}
