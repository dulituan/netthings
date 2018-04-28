/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.session;

import org.thingsboard.server.common.data.id.SessionId;

public class BasicSessionMsg implements SessionMsg {

    private final SessionContext ctx;

    public BasicSessionMsg(SessionContext ctx) {
        super();
        this.ctx = ctx;
    }

    @Override
    public SessionId getSessionId() {
        return ctx.getSessionId();
    }

    @Override
    public SessionContext getSessionContext() {
        return ctx;
    }

    @Override
    public String toString() {
        return "BasicSessionMsg [ctx=" + ctx + "]";
    }

}
