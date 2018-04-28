/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.component;

import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentType;

import java.util.List;
import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
public interface ComponentDiscoveryService {

    void discoverComponents();

    List<ComponentDescriptor> getComponents(ComponentType type);

    Optional<ComponentDescriptor> getComponent(String clazz);

    List<ComponentDescriptor> getPluginActions(String pluginClazz);

}
