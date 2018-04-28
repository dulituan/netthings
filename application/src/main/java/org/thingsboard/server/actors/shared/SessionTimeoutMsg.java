/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.shared;

import lombok.Data;
import org.thingsboard.server.common.data.id.SessionId;

import java.io.Serializable;

@Data
public class SessionTimeoutMsg implements Serializable {

    private static final long serialVersionUID = 1L;

    private final SessionId sessionId;
}
