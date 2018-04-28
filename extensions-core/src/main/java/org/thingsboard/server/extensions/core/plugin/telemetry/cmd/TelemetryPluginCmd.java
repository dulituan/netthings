/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.telemetry.cmd;

/**
 * @author Andrew Shvayka
 */
public interface TelemetryPluginCmd {

    int getCmdId();

    void setCmdId(int cmdId);

    String getKeys();

}
