/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import java.util.UUID;

/**
 * @author Andrew Shvayka
 */
public final class TimeoutUUIDMsg extends TimeoutMsg<UUID> {

    public TimeoutUUIDMsg(UUID id, long timeout) {
        super(id, timeout);
    }

}
