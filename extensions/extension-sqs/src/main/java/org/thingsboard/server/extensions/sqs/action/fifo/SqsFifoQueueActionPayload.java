/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sqs.action.fifo;

import lombok.Builder;
import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

/**
 * Created by Valerii Sosliuk on 11/10/2017.
 */
@Data
@Builder
public class SqsFifoQueueActionPayload implements Serializable {

    private final String queue;
    private final String msgBody;
    private final String deviceId;

    private final Integer requestId;
    private final MsgType msgType;
    private final boolean sync;

}
