/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.plugin;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ValidationResult {

    private final ValidationResultCode resultCode;
    private final String message;

    public static ValidationResult ok() {
        return new ValidationResult(ValidationResultCode.OK, "Ok");
    }

    public static ValidationResult accessDenied(String message) {
        return new ValidationResult(ValidationResultCode.ACCESS_DENIED, message);
    }

    public static ValidationResult entityNotFound(String message) {
        return new ValidationResult(ValidationResultCode.ENTITY_NOT_FOUND, message);
    }

    public static ValidationResult unauthorized(String message) {
        return new ValidationResult(ValidationResultCode.UNAUTHORIZED, message);
    }

    public static ValidationResult internalError(String message) {
        return new ValidationResult(ValidationResultCode.INTERNAL_ERROR, message);
    }

}
