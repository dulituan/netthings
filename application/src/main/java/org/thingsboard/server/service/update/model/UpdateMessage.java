/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.update.model;

import lombok.Data;

@Data
public class UpdateMessage {

    private final String message;
    private final boolean isUpdateAvailable;

}
