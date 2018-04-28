/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.exception;

public class BufferLimitException extends RuntimeException {

    private static final long serialVersionUID = 4513762009041887588L;

    public BufferLimitException() {
        super("Rate Limit Buffer is full");
    }
}
