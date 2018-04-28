/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;

import java.nio.ByteBuffer;

public class EmptyPluginWebsocketMsg extends AbstractPluginWebSocketMsg<ByteBuffer> {

    private static final long serialVersionUID = 1L;
    private static ByteBuffer EMPTY = ByteBuffer.wrap(new byte[0]);

    protected EmptyPluginWebsocketMsg(PluginWebsocketSessionRef sessionRef) {
        super(sessionRef, EMPTY);
    }
}
