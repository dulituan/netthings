/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins.msg;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Andrew Shvayka
 */
@Data
public class ToDeviceRpcRequestBody implements Serializable {
    private final String method;
    private final String params;
}
