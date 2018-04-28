/**
 *
 */
package org.thingsboard.server.extensions.core.plugin.rpc;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import org.thingsboard.server.extensions.api.plugins.msg.ToDeviceRpcRequest;

/**
 * @author Andrew Shvayka
 */
@Data
public class LocalRequestMetaData {
    private final ToDeviceRpcRequest request;
    private final DeferredResult<ResponseEntity> responseWriter;
}
