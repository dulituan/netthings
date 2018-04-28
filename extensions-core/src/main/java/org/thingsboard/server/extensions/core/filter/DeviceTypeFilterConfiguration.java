/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class DeviceTypeFilterConfiguration {

    private DeviceTypeName[] deviceTypes;

    @Data
    public static class DeviceTypeName {
        private String name;
    }

}
