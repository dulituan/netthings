/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.mail;

import lombok.Data;
import org.thingsboard.server.extensions.core.plugin.KeyValuePluginProperties;

import java.util.List;

/**
 * @author Andrew Shvayka
 */
@Data
public class MailPluginConfiguration {
    private String host;
    private Integer port;
    private String username;
    private String password;
    private List<KeyValuePluginProperties> otherProperties;
}
