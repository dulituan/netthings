/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.update;

import org.thingsboard.server.service.update.model.UpdateMessage;

public interface UpdateService {

    UpdateMessage checkUpdates();

}
