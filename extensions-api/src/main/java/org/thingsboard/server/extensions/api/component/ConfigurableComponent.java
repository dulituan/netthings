/**
 *
 */
package org.thingsboard.server.extensions.api.component;

/**
 * @author Andrew Shvayka
 */
public interface ConfigurableComponent<T> {

    void init(T configuration);

}
