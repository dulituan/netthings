/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins;

public class PluginException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PluginException(String msg, Exception e) {
        super(msg, e);
    }
    
}
