/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.ws.msg;

import org.thingsboard.server.extensions.api.plugins.ws.PluginWebsocketSessionRef;

import java.nio.ByteBuffer;

public class BinaryPluginWebSocketMsg extends AbstractPluginWebSocketMsg<ByteBuffer> {

    private static final long serialVersionUID = 1L;

    public BinaryPluginWebSocketMsg(PluginWebsocketSessionRef sessionRef, ByteBuffer payload) {
        super(sessionRef, payload);
    }
}
