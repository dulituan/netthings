/**
 *
 */
package org.thingsboard.server.common.transport.session;

import lombok.extern.slf4j.Slf4j;
import org.thingsboard.server.common.data.Device;
import org.thingsboard.server.common.data.security.DeviceCredentialsFilter;
import org.thingsboard.server.common.data.security.DeviceTokenCredentials;
import org.thingsboard.server.common.msg.session.SessionContext;
import org.thingsboard.server.common.transport.SessionMsgProcessor;
import org.thingsboard.server.common.transport.auth.DeviceAuthResult;
import org.thingsboard.server.common.transport.auth.DeviceAuthService;

import java.util.Optional;

/**
 * @author Andrew Shvayka
 */
@Slf4j
public abstract class DeviceAwareSessionContext implements SessionContext {

    protected final DeviceAuthService authService;
    protected final SessionMsgProcessor processor;

    protected volatile Device device;

    public DeviceAwareSessionContext(SessionMsgProcessor processor, DeviceAuthService authService) {
        this.processor = processor;
        this.authService = authService;
    }

    public DeviceAwareSessionContext(SessionMsgProcessor processor, DeviceAuthService authService, Device device) {
        this(processor, authService);
        this.device = device;
    }


    public boolean login(DeviceCredentialsFilter credentials) {
        DeviceAuthResult result = authService.process(credentials);
        if (result.isSuccess()) {
            Optional<Device> deviceOpt = authService.findDeviceById(result.getDeviceId());
            if (deviceOpt.isPresent()) {
                device = deviceOpt.get();
            }
            return true;
        } else {
            log.debug("Can't find device using credentials [{}] due to {}", credentials, result.getErrorMsg());
            return false;
        }
    }

    public DeviceAuthService getAuthService() {
        return authService;
    }

    public SessionMsgProcessor getProcessor() {
        return processor;
    }

    public Device getDevice() {
        return device;
    }
}
