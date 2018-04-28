/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport;

import org.thingsboard.server.common.msg.session.AdaptorToSessionActorMsg;
import org.thingsboard.server.common.msg.session.MsgType;
import org.thingsboard.server.common.msg.session.SessionActorToAdaptorMsg;
import org.thingsboard.server.common.msg.session.SessionContext;
import org.thingsboard.server.common.transport.adaptor.AdaptorException;

import java.util.Optional;

public interface TransportAdaptor<C extends SessionContext, T, V> {

    AdaptorToSessionActorMsg convertToActorMsg(C ctx, MsgType type, T inbound) throws AdaptorException;

    Optional<V> convertToAdaptorMsg(C ctx, SessionActorToAdaptorMsg msg) throws AdaptorException;

}
