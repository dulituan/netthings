/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class TimeoutMsg<T> {
    private final T id;
    private final long timeout;
}
