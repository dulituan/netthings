/**
 *
 */
package org.thingsboard.server.extensions.core.action.telemetry;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TelemetryPluginActionConfiguration {

    private String timeUnit;
    private int ttlValue;

}
