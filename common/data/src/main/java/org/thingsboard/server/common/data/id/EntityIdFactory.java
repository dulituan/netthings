/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.data.id;

import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.common.data.alarm.AlarmId;

import java.util.UUID;

/**
 * Created by ashvayka on 25.04.17.
 */
public class EntityIdFactory {

    public static EntityId getByTypeAndId(String type, String uuid) {
        return getByTypeAndUuid(EntityType.valueOf(type), UUID.fromString(uuid));
    }

    public static EntityId getByTypeAndUuid(String type, UUID uuid) {
        return getByTypeAndUuid(EntityType.valueOf(type), uuid);
    }

    public static EntityId getByTypeAndUuid(EntityType type, UUID uuid) {
        switch (type) {
            case TENANT:
                return new TenantId(uuid);
            case CUSTOMER:
                return new CustomerId(uuid);
            case USER:
                return new UserId(uuid);
            case RULE:
                return new RuleId(uuid);
            case PLUGIN:
                return new PluginId(uuid);
            case DASHBOARD:
                return new DashboardId(uuid);
            case DEVICE:
                return new DeviceId(uuid);
            case ASSET:
                return new AssetId(uuid);
            case ALARM:
                return new AlarmId(uuid);
        }
        throw new IllegalArgumentException("EntityType " + type + " is not supported!");
    }
}
