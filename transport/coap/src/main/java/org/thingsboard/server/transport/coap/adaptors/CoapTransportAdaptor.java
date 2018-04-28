/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.transport.coap.adaptors;

import org.eclipse.californium.core.coap.Request;
import org.eclipse.californium.core.coap.Response;
import org.thingsboard.server.common.transport.TransportAdaptor;
import org.thingsboard.server.transport.coap.session.CoapSessionCtx;

public interface CoapTransportAdaptor extends TransportAdaptor<CoapSessionCtx, Request, Response> {

}
