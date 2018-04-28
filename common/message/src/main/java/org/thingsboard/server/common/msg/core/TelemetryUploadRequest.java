/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.msg.core;

import java.util.List;
import java.util.Map;

import org.thingsboard.server.common.data.kv.KvEntry;
import org.thingsboard.server.common.msg.session.FromDeviceMsg;
import org.thingsboard.server.common.msg.session.FromDeviceRequestMsg;

public interface TelemetryUploadRequest extends FromDeviceRequestMsg {

    Map<Long, List<KvEntry>> getData();

}
