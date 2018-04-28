/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.cluster.rpc;

import org.thingsboard.server.actors.rpc.RpcBroadcastMsg;
import org.thingsboard.server.actors.rpc.RpcSessionCreateRequestMsg;
import org.thingsboard.server.actors.rpc.RpcSessionTellMsg;
import org.thingsboard.server.common.msg.cluster.ToAllNodesMsg;
import org.thingsboard.server.common.msg.core.ToDeviceSessionActorMsg;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.extensions.api.device.ToDeviceActorNotificationMsg;
import org.thingsboard.server.extensions.api.plugins.msg.ToPluginActorMsg;
import org.thingsboard.server.extensions.api.plugins.rpc.PluginRpcMsg;
import org.thingsboard.server.gen.cluster.ClusterAPIProtos;

/**
 * @author Andrew Shvayka
 */
public interface RpcMsgListener {

    void onMsg(ToDeviceActorMsg msg);

    void onMsg(ToDeviceActorNotificationMsg msg);

    void onMsg(ToDeviceSessionActorMsg msg);

    void onMsg(ToAllNodesMsg nodeMsg);

    void onMsg(ToPluginActorMsg msg);

    void onMsg(RpcSessionCreateRequestMsg msg);

    void onMsg(RpcSessionTellMsg rpcSessionTellMsg);

    void onMsg(RpcBroadcastMsg rpcBroadcastMsg);

}
