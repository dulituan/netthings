/**
 *
 */
package org.thingsboard.server.extensions.sqs.action.standard;

import lombok.Builder;
import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

/**
 * Created by Valerii Sosliuk on 11/6/2017.
 */
@Data
@Builder
public class SqsStandardQueueActionPayload implements Serializable {

    private final String queue;
    private final String msgBody;
    private final int delaySeconds;

    private final Integer requestId;
    private final MsgType msgType;
    private final boolean sync;

}
