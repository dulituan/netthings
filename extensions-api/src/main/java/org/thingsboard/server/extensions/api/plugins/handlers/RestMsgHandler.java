/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.handlers;

import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.rest.PluginRestMsg;

/**
 * @author Andrew Shvayka
 */
public interface RestMsgHandler {

    void process(PluginContext ctx, PluginRestMsg msg);

}
