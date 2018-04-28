/**
 *
 */
package org.thingsboard.server.extensions.mqtt.action;

import lombok.Builder;
import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

@Data
@Builder
public class MqttActionPayload implements Serializable {

    private final boolean sync;
    private final String topic;
    private final String msgBody;

    private final Integer requestId;
    private final MsgType msgType;
}
