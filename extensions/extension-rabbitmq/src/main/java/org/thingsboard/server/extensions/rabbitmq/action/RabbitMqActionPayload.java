/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.rabbitmq.action;

import lombok.Builder;
import lombok.Data;
import org.thingsboard.server.common.msg.session.MsgType;

import java.io.Serializable;

/**
 * @author Andrew Shvayka
 */
@Data
@Builder
public class RabbitMqActionPayload implements Serializable {

    private final String exchange;
    private final String queueName;
    private final String messageProperties;
    private final String payload;

    private final boolean sync;
    private final Integer requestId;
    private final MsgType msgType;
}
