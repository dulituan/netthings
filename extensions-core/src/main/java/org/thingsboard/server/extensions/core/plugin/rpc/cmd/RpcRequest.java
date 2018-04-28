/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.plugin.rpc.cmd;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class RpcRequest {
    private final String methodName;
    private final String requestData;
    private Long timeout;
}
