/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.transport.http.session;

import org.thingsboard.server.common.data.id.SessionId;

import java.util.UUID;

/**
 * @author Andrew Shvayka
 */
public class HttpSessionId implements SessionId {

    private final UUID id;

    public HttpSessionId() {
        this.id = UUID.randomUUID();
    }

    @Override
    public String toUidStr() {
        return id.toString();
    }
}
