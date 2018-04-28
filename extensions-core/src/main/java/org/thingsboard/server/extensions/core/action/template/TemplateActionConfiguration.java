/**
 *
 */
package org.thingsboard.server.extensions.core.action.template;

/**
 * @author Andrew Shvayka
 */
public interface TemplateActionConfiguration {

    boolean isSync();
    String getTemplate();
}
