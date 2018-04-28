/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;

public class TextPluginWebSocketMsg extends AbstractPluginWebSocketMsg<String> {

    private static final long serialVersionUID = 1L;
    
    public TextPluginWebSocketMsg(PluginWebsocketSessionRef sessionRef, String payload) {
        super(sessionRef, payload);
    }

}
