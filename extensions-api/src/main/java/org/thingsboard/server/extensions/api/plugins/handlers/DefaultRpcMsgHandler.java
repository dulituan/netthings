/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.handlers;

import org.thingsboard.server.extensions.api.plugins.PluginContext;
import org.thingsboard.server.extensions.api.plugins.rpc.RpcMsg;

/**
 * @author Andrew Shvayka
 */
public class DefaultRpcMsgHandler implements RpcMsgHandler {

    @Override
    public void process(PluginContext ctx, RpcMsg msg) {
        throw new RuntimeException("Not registered msg type: " + msg.getMsgClazz() + "!");
    }
}
