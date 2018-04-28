/**
 *
 */
package org.thingsboard.server.actors.service;

import org.thingsboard.server.extensions.api.plugins.rest.PluginRestMsg;

public interface RestMsgProcessor {

    void process(PluginRestMsg msg);

}
