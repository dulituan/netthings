/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.install;

public interface DatabaseUpgradeService {

    void upgradeDatabase(String fromVersion) throws Exception;

}
