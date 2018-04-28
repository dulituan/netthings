/**
 *
 */
package org.thingsboard.server.common.msg.core;

import java.util.Set;

import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;

public interface UpdateAttributesRequest extends FromDeviceRequestMsg {

    Set<AttributeKvEntry> getAttributes();

}
