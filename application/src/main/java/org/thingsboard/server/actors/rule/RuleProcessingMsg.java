/**
 *
 */
package org.thingsboard.server.actors.rule;

public class RuleProcessingMsg {

    private final ChainProcessingContext ctx;

    public RuleProcessingMsg(ChainProcessingContext ctx) {
        super();
        this.ctx = ctx;
    }

    public ChainProcessingContext getCtx() {
        return ctx;
    }

}
