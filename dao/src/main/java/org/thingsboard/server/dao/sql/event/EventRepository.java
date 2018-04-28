/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.sql.event;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.EventEntity;
import org.thingsboard.server.dao.util.SqlDao;

/**
 * Created by Valerii Sosliuk on 5/3/2017.
 */
@SqlDao
public interface EventRepository extends CrudRepository<EventEntity, String>, JpaSpecificationExecutor<EventEntity> {

    EventEntity findByTenantIdAndEntityTypeAndEntityIdAndEventTypeAndEventUid(String tenantId,
                                                                              EntityType entityType,
                                                                              String entityId,
                                                                              String eventType,
                                                                              String eventUid);

    EventEntity findByTenantIdAndEntityTypeAndEntityId(String tenantId,
                                                       EntityType entityType,
                                                       String entityId);
}
