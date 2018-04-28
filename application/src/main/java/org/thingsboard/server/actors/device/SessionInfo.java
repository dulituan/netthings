/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.device;

import lombok.Data;
import org.thingsboard.server.common.data.id.SessionId;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.common.msg.session.SessionType;

import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
@Data
public class SessionInfo {
    private final SessionType type;
    private final Optional<ServerAddress> server;
}
