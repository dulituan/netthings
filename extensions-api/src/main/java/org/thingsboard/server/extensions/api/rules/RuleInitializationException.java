/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.rules;

public class RuleInitializationException extends RuleException {

    private static final long serialVersionUID = 1L;

    public RuleInitializationException(String msg, Exception e) {
        super(msg, e);
    }
    
    public RuleInitializationException(String msg) {
        super(msg, null);
    }
}
