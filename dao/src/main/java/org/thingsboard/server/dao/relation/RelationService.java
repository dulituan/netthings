/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.relation;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.relation.EntityRelation;
import org.thingsboard.server.common.data.relation.EntityRelationInfo;
import org.thingsboard.server.common.data.relation.EntityRelationsQuery;
import org.thingsboard.server.common.data.relation.RelationTypeGroup;

import java.util.List;

/**
 * Created by ashvayka on 27.04.17.
 */
public interface RelationService {

    ListenableFuture<Boolean> checkRelation(EntityId from, EntityId to, String relationType, RelationTypeGroup typeGroup);

    EntityRelation getRelation(EntityId from, EntityId to, String relationType, RelationTypeGroup typeGroup);

    ListenableFuture<EntityRelation> getRelationAsync(EntityId from, EntityId to, String relationType, RelationTypeGroup typeGroup);

    boolean saveRelation(EntityRelation relation);

    ListenableFuture<Boolean> saveRelationAsync(EntityRelation relation);

    boolean deleteRelation(EntityRelation relation);

    ListenableFuture<Boolean> deleteRelationAsync(EntityRelation relation);

    boolean deleteRelation(EntityId from, EntityId to, String relationType, RelationTypeGroup typeGroup);

    ListenableFuture<Boolean> deleteRelationAsync(EntityId from, EntityId to, String relationType, RelationTypeGroup typeGroup);

    boolean deleteEntityRelations(EntityId entity);

    ListenableFuture<Boolean> deleteEntityRelationsAsync(EntityId entity);

    List<EntityRelation> findByFrom(EntityId from, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelation>> findByFromAsync(EntityId from, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelationInfo>> findInfoByFrom(EntityId from, RelationTypeGroup typeGroup);

    List<EntityRelation> findByFromAndType(EntityId from, String relationType, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelation>> findByFromAndTypeAsync(EntityId from, String relationType, RelationTypeGroup typeGroup);

    List<EntityRelation> findByTo(EntityId to, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelation>> findByToAsync(EntityId to, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelationInfo>> findInfoByTo(EntityId to, RelationTypeGroup typeGroup);

    List<EntityRelation> findByToAndType(EntityId to, String relationType, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelation>> findByToAndTypeAsync(EntityId to, String relationType, RelationTypeGroup typeGroup);

    ListenableFuture<List<EntityRelation>> findByQuery(EntityRelationsQuery query);

    ListenableFuture<List<EntityRelationInfo>> findInfoByQuery(EntityRelationsQuery query);

//    TODO: This method may be useful for some validations in the future
//    ListenableFuture<Boolean> checkRecursiveRelation(EntityId from, EntityId to);

}
