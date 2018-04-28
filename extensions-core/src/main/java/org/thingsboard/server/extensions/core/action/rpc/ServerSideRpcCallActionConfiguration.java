/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.action.rpc;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class ServerSideRpcCallActionConfiguration {

    private String sendFlag;

    private String deviceIdTemplate;
    private String rpcCallMethodTemplate;
    private String rpcCallBodyTemplate;
    private long rpcCallTimeoutInSec;
    private String fromDeviceRelationTemplate;
    private String toDeviceRelationTemplate;
}
