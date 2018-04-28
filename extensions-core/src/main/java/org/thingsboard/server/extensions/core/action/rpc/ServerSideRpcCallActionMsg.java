/**
 *
 */
package org.thingsboard.server.extensions.core.action.rpc;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by ashvayka on 14.09.17.
 */
@Data
@Builder
public class ServerSideRpcCallActionMsg implements Serializable {

    private String deviceId;
    private String rpcCallMethod;
    private String rpcCallBody;
    private long rpcCallTimeoutInSec;

    private String fromDeviceRelation;
    private String toDeviceRelation;

}
