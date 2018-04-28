/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.plugin;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class KeyValuePluginProperties {
    private String key;
    private String value;
}
