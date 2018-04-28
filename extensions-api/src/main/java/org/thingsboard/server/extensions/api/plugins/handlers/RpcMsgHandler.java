/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.handlers;

import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.rpc.RpcMsg;

/**
 * @author Andrew Shvayka
 */
public interface RpcMsgHandler {

    void process(PluginContext ctx, RpcMsg msg);

}
