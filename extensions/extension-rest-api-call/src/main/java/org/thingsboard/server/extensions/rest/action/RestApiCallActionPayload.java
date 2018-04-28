/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.rest.action;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

@Data
@Builder
public class RestApiCallActionPayload implements Serializable {
    private final String actionPath;
    private final String msgBody;
    private final HttpMethod httpMethod;
    private final HttpStatus expectedResultCode;
    private final boolean sync;

    private final Integer requestId;
    private final MsgType msgType;
}
