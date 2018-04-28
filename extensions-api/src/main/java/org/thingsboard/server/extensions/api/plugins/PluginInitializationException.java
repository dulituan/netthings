/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins;

public class PluginInitializationException extends PluginException {

    private static final long serialVersionUID = 1L;

    public PluginInitializationException(String msg, Exception e) {
        super(msg, e);
    }
    
    public PluginInitializationException(String msg) {
        super(msg, null);
    }
}
