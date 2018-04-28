/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class InternalErrorException extends Exception implements ToErrorResponseEntity {

    public InternalErrorException(String message) {
        super(message);
    }

    @Override
    public ResponseEntity<String> toErrorResponseEntity() {
        return new ResponseEntity<>(getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
