/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.rules;

public class RuleException extends Exception {

    private static final long serialVersionUID = 1L;

    public RuleException(String msg) {
        super(msg);
    }

    public RuleException(String msg, Exception e) {
        super(msg, e);
    }

}
