/**
 *
 */
package org.thingsboard.server.extensions.kafka.action;

import lombok.Builder;
import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

@Data
@Builder
public class KafkaActionPayload implements Serializable {

    private final String topic;
    private final String msgBody;
    private final boolean sync;

    private final Integer requestId;
    private final MsgType msgType;
}
