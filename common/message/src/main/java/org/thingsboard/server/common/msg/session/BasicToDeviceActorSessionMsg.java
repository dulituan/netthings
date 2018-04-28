/**
 *
 */
package org.thingsboard.server.common.msg.session;

import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.id.CustomerId;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.SessionId;
import org.thingsboard.server.common.data.id.TenantId;

public class BasicToDeviceActorSessionMsg implements ToDeviceActorSessionMsg {

    private final TenantId tenantId;
    private final CustomerId customerId;
    private final DeviceId deviceId;
    private final AdaptorToSessionActorMsg msg;

    public BasicToDeviceActorSessionMsg(Device device, AdaptorToSessionActorMsg msg) {
        super();
        this.tenantId = device.getTenantId();
        this.customerId = device.getCustomerId();
        this.deviceId = device.getId();
        this.msg = msg;
    }

    public BasicToDeviceActorSessionMsg(ToDeviceActorSessionMsg deviceMsg) {
        this.tenantId = deviceMsg.getTenantId();
        this.customerId = deviceMsg.getCustomerId();
        this.deviceId = deviceMsg.getDeviceId();
        this.msg = deviceMsg.getSessionMsg();
    }

    @Override
    public DeviceId getDeviceId() {
        return deviceId;
    }

    @Override
    public CustomerId getCustomerId() {
        return customerId;
    }

    public TenantId getTenantId() {
        return tenantId;
    }

    @Override
    public SessionId getSessionId() {
        return msg.getSessionId();
    }

    @Override
    public AdaptorToSessionActorMsg getSessionMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "BasicToDeviceActorSessionMsg [tenantId=" + tenantId + ", customerId=" + customerId + ", deviceId=" + deviceId + ", msg=" + msg
                + "]";
    }

}
