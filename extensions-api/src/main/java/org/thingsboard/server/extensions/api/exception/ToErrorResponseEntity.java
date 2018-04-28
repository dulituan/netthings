/**
 *
 */
package org.thingsboard.server.extensions.api.exception;

import org.springframework.http.ResponseEntity;

import java.io.Serializable;

public interface ToErrorResponseEntity extends Serializable {

    ResponseEntity<String> toErrorResponseEntity();

}
