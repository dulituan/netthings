/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.plugin.telemetry.cmd;

import java.util.List;

/**
 * @author Andrew Shvayka
 */
public class TelemetryPluginCmdsWrapper {

    private List<AttributesSubscriptionCmd> attrSubCmds;

    private List<TimeseriesSubscriptionCmd> tsSubCmds;

    private List<GetHistoryCmd> historyCmds;

    public TelemetryPluginCmdsWrapper() {
        super();
    }

    public List<AttributesSubscriptionCmd> getAttrSubCmds() {
        return attrSubCmds;
    }

    public void setAttrSubCmds(List<AttributesSubscriptionCmd> attrSubCmds) {
        this.attrSubCmds = attrSubCmds;
    }

    public List<TimeseriesSubscriptionCmd> getTsSubCmds() {
        return tsSubCmds;
    }

    public void setTsSubCmds(List<TimeseriesSubscriptionCmd> tsSubCmds) {
        this.tsSubCmds = tsSubCmds;
    }

    public List<GetHistoryCmd> getHistoryCmds() {
        return historyCmds;
    }

    public void setHistoryCmds(List<GetHistoryCmd> historyCmds) {
        this.historyCmds = historyCmds;
    }
}
