/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.install;

public interface SystemDataLoaderService {

    void createSysAdmin() throws Exception;

    void createAdminSettings() throws Exception;

    void loadSystemWidgets() throws Exception;

    void loadSystemPlugins() throws Exception;

    void loadSystemRules() throws Exception;

    void loadDemoData() throws Exception;

    void deleteSystemWidgetBundle(String bundleAlias) throws Exception;

}
