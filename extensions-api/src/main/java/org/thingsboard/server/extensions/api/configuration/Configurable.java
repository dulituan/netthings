/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.configuration;

public interface Configurable<C extends Configuration> {

    Class<C> getConfigurationClass();

    void validate(C configuration) throws ConfigurationValidationException;

    void configure(C configuration);
    
}
