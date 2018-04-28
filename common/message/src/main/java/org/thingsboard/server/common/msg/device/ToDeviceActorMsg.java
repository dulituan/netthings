/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.device;

import java.io.Serializable;
import java.util.Optional;

import org.thingsboard.server.common.data.id.SessionId;
import org.thingsboard.server.common.msg.aware.CustomerAwareMsg;
import org.thingsboard.server.common.msg.aware.DeviceAwareMsg;
import org.thingsboard.server.common.msg.aware.TenantAwareMsg;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.SessionType;

public interface ToDeviceActorMsg extends DeviceAwareMsg, CustomerAwareMsg, TenantAwareMsg, Serializable {

    SessionId getSessionId();

    SessionType getSessionType();

    Optional<ServerAddress> getServerAddress();
    
    FromDeviceMsg getPayload();

    ToDeviceActorMsg toOtherAddress(ServerAddress otherAddress);
}
