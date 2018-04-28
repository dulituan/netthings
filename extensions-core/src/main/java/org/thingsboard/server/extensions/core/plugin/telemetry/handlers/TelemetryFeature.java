/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.plugin.telemetry.handlers;

/**
 * Created by ashvayka on 08.05.17.
 */
public enum TelemetryFeature {

    ATTRIBUTES, TIMESERIES;

    public static TelemetryFeature forName(String name) {
        return TelemetryFeature.valueOf(name.toUpperCase());
    }

}
