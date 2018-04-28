/**
 *
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.extensions.api.rules.RuleContext;
import org.thingsboard.server.extensions.api.rules.RuleFilter;

import javax.script.ScriptException;

/**
 * @author Andrew Shvayka
 */
@Slf4j
public abstract class BasicJsFilter implements RuleFilter<JsFilterConfiguration> {

    protected JsFilterConfiguration configuration;
    protected NashornJsEvaluator evaluator;

    @Override
    public void init(JsFilterConfiguration configuration) {
        this.configuration = configuration;
        initEvaluator(configuration);
    }

    @Override
    public boolean filter(RuleContext ctx, ToDeviceActorMsg msg) {
        try {
            return doFilter(ctx, msg);
        } catch (ScriptException e) {
            log.warn("RuleFilter evaluation exception: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    protected abstract boolean doFilter(RuleContext ctx, ToDeviceActorMsg msg) throws ScriptException;

    @Override
    public void resume() {
        initEvaluator(configuration);
    }

    @Override
    public void suspend() {
        destroyEvaluator();
    }

    @Override
    public void stop() {
        destroyEvaluator();
    }

    private void initEvaluator(JsFilterConfiguration configuration) {
        evaluator = new NashornJsEvaluator(configuration.getFilter());
    }

    private void destroyEvaluator() {
        if (evaluator != null) {
            evaluator.destroy();
        }
    }

}
