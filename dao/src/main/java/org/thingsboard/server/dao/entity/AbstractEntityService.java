/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.entity;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.dao.relation.RelationService;

import java.util.concurrent.ExecutionException;

@Slf4j
public abstract class AbstractEntityService {

    @Autowired
    protected RelationService relationService;

    protected void deleteEntityRelations(EntityId entityId) {
        log.trace("Executing deleteEntityRelations [{}]", entityId);
        relationService.deleteEntityRelations(entityId);
    }

}
