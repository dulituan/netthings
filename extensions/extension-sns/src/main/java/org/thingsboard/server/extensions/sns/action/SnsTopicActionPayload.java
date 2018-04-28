/**
 *
 */
package org.thingsboard.server.extensions.sns.action;

import lombok.Builder;
import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

/**
 * Created by Valerii Sosliuk on 11/15/2017.
 */
@Data
@Builder
public class SnsTopicActionPayload implements Serializable {

    private final String topicArn;
    private final String msgBody;

    private final Integer requestId;
    private final MsgType msgType;
    private final boolean sync;
}
