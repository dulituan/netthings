/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.session;

import java.util.Optional;

public class BasicSessionActorToAdaptorMsg extends BasicSessionMsg implements SessionActorToAdaptorMsg {

    private final ToDeviceMsg msg;

    public BasicSessionActorToAdaptorMsg(SessionContext ctx, ToDeviceMsg msg) {
        super(ctx);
        this.msg = msg;
    }

    @Override
    public ToDeviceMsg getMsg() {
        return msg;
    }

}
