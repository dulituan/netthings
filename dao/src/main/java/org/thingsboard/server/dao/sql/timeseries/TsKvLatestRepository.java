/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.sql.timeseries;

import org.springframework.data.repository.CrudRepository;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.TsKvLatestCompositeKey;
import org.thingsboard.server.dao.model.sql.TsKvLatestEntity;
import org.thingsboard.server.dao.util.SqlDao;

import java.util.List;
import java.util.UUID;

@SqlDao
public interface TsKvLatestRepository extends CrudRepository<TsKvLatestEntity, TsKvLatestCompositeKey> {

    List<TsKvLatestEntity> findAllByEntityTypeAndEntityId(EntityType entityType, String entityId);
}
