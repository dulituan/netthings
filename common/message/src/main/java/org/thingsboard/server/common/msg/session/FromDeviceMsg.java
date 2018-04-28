/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.session;

import java.io.Serializable;

public interface FromDeviceMsg extends Serializable {

    MsgType getMsgType();

}
