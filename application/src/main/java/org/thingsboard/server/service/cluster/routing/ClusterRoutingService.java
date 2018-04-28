/**
 *
 */
package org.thingsboard.server.service.cluster.routing;

import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.UUIDBased;
import org.thingsboard.server.common.msg.cluster.ServerAddress;
import org.thingsboard.server.service.cluster.discovery.ServerInstance;

import java.util.Optional;
import java.util.UUID;

/**
 * @author Andrew Shvayka
 */
public interface ClusterRoutingService {

    ServerAddress getCurrentServer();

    Optional<ServerAddress> resolveByUuid(UUID uuid);

    Optional<ServerAddress> resolveById(EntityId entityId);

}
