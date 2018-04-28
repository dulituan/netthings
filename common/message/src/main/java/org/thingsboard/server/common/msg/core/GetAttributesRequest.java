/**
 *
 */
package org.thingsboard.server.common.msg.core;

import java.util.Optional;
import java.util.Set;

import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;

public interface GetAttributesRequest extends FromDeviceRequestMsg {

    Optional<Set<String>> getClientAttributeNames();
    Optional<Set<String>> getSharedAttributeNames();

}
