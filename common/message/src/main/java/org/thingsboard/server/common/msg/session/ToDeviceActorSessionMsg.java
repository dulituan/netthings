/**
 *
 */
package org.thingsboard.server.common.msg.session;

import org.thingsboard.server.common.msg.aware.CustomerAwareMsg;
import org.thingsboard.server.common.msg.aware.DeviceAwareMsg;
import org.thingsboard.server.common.msg.aware.SessionAwareMsg;
import org.thingsboard.server.common.msg.aware.TenantAwareMsg;

public interface ToDeviceActorSessionMsg extends DeviceAwareMsg, CustomerAwareMsg, TenantAwareMsg, SessionAwareMsg {

    AdaptorToSessionActorMsg getSessionMsg();

}
