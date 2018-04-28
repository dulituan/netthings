/**
 *
 */
package org.thingsboard.server.common.transport.quota;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
@Component
public class HostRequestLimitPolicy {

    private final long limit;

    public HostRequestLimitPolicy(@Value("${quota.host.limit}") long limit) {
        this.limit = limit;
    }

    public boolean isValid(long currentValue) {
        return currentValue <= limit;
    }

}
