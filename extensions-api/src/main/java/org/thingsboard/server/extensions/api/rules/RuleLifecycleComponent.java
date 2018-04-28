/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.rules;

/**
 * @author Andrew Shvayka
 */
public interface RuleLifecycleComponent {

    void resume();

    void suspend();

    void stop();

}
