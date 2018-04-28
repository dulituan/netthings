/**
 *
 */
package org.thingsboard.server.common.msg.core;

import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.MsgType;

/**
 * @author Andrew Shvayka
 */
public class SessionOpenMsg implements FromDeviceMsg {
    @Override
    public MsgType getMsgType() {
        return MsgType.SESSION_OPEN;
    }
}
