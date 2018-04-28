/**
 *
 */
package org.thingsboard.server.common.msg.cluster;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public final class ClusterEventMsg {

    private final ServerAddress serverAddress;
    private final boolean added;

}
