/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.configuration;

public class ConfigurationValidationException extends Exception {

    private static final long serialVersionUID = 1L;

    public ConfigurationValidationException(String msg, Exception cause){
        super(msg, cause);
    }
    
}
