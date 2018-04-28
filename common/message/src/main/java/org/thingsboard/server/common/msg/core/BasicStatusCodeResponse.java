/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import lombok.ToString;
import org.thingsboard.server.common.msg.session.MsgType;

@ToString
public class BasicStatusCodeResponse extends BasicResponseMsg<Integer> implements StatusCodeResponse {

    private static final long serialVersionUID = 1L;

    public static BasicStatusCodeResponse onSuccess(MsgType requestMsgType, Integer requestId) {
        return BasicStatusCodeResponse.onSuccess(requestMsgType, requestId, 0);
    }

    public static BasicStatusCodeResponse onSuccess(MsgType requestMsgType, Integer requestId, Integer code) {
        return new BasicStatusCodeResponse(requestMsgType, requestId, true, null, code);
    }

    public static BasicStatusCodeResponse onError(MsgType requestMsgType, Integer requestId, Exception error) {
        return new BasicStatusCodeResponse(requestMsgType, requestId, false, error, null);
    }

    private BasicStatusCodeResponse(MsgType requestMsgType, Integer requestId, boolean success, Exception error, Integer code) {
        super(requestMsgType, requestId, MsgType.STATUS_CODE_RESPONSE, success, error, code);
    }
}
