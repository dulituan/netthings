/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.cluster.discovery;

/**
 * @author Andrew Shvayka
 */
public interface DiscoveryServiceListener {

    void onServerAdded(ServerInstance server);

    void onServerUpdated(ServerInstance server);

    void onServerRemoved(ServerInstance server);
}
