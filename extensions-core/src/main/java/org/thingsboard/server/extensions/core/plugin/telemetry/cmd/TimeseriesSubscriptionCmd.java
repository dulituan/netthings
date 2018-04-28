/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.plugin.telemetry.cmd;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thingsboard.server.extensions.core.plugin.telemetry.sub.SubscriptionType;

/**
 * @author Andrew Shvayka
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TimeseriesSubscriptionCmd extends SubscriptionCmd {

    private long startTs;
    private long timeWindow;
    private long interval;
    private int limit;
    private String agg;

    @Override
    public SubscriptionType getType() {
        return SubscriptionType.TIMESERIES;
    }
}
