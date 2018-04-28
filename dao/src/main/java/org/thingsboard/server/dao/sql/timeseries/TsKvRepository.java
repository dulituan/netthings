/**
 *
 */
package org.thingsboard.server.dao.sql.timeseries;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.thingsboard.server.common.data.EntityType;
import org.thingsboard.server.dao.model.sql.TsKvCompositeKey;
import org.thingsboard.server.dao.model.sql.TsKvEntity;
import org.thingsboard.server.dao.util.SqlDao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@SqlDao
public interface TsKvRepository extends CrudRepository<TsKvEntity, TsKvCompositeKey> {

    @Query("SELECT tskv FROM TsKvEntity tskv WHERE tskv.entityId = :entityId " +
            "AND tskv.entityType = :entityType AND tskv.key = :entityKey " +
            "AND tskv.ts > :startTs AND tskv.ts < :endTs ORDER BY tskv.ts DESC")
    List<TsKvEntity> findAllWithLimit(@Param("entityId") String entityId,
                                      @Param("entityType") EntityType entityType,
                                      @Param("entityKey") String key,
                                      @Param("startTs") long startTs,
                                      @Param("endTs") long endTs,
                                      Pageable pageable);

    @Async
    @Query("SELECT new TsKvEntity(MAX(tskv.strValue), MAX(tskv.longValue), MAX(tskv.doubleValue)) FROM TsKvEntity tskv " +
            "WHERE tskv.entityId = :entityId AND tskv.entityType = :entityType " +
            "AND tskv.key = :entityKey AND tskv.ts > :startTs AND tskv.ts < :endTs")
    CompletableFuture<TsKvEntity> findMax(@Param("entityId") String entityId,
                                          @Param("entityType") EntityType entityType,
                                          @Param("entityKey") String entityKey,
                                          @Param("startTs") long startTs,
                                          @Param("endTs") long endTs);

    @Async
    @Query("SELECT new TsKvEntity(MIN(tskv.strValue), MIN(tskv.longValue), MIN(tskv.doubleValue)) FROM TsKvEntity tskv " +
            "WHERE tskv.entityId = :entityId AND tskv.entityType = :entityType " +
            "AND tskv.key = :entityKey AND tskv.ts > :startTs AND tskv.ts < :endTs")
    CompletableFuture<TsKvEntity> findMin(@Param("entityId") String entityId,
                       @Param("entityType") EntityType entityType,
                       @Param("entityKey") String entityKey,
                       @Param("startTs") long startTs,
                       @Param("endTs") long endTs);

    @Async
    @Query("SELECT new TsKvEntity(COUNT(tskv.booleanValue), COUNT(tskv.strValue), COUNT(tskv.longValue), COUNT(tskv.doubleValue)) FROM TsKvEntity tskv " +
            "WHERE tskv.entityId = :entityId AND tskv.entityType = :entityType " +
            "AND tskv.key = :entityKey AND tskv.ts > :startTs AND tskv.ts < :endTs")
    CompletableFuture<TsKvEntity> findCount(@Param("entityId") String entityId,
                                 @Param("entityType") EntityType entityType,
                                 @Param("entityKey") String entityKey,
                                 @Param("startTs") long startTs,
                                 @Param("endTs") long endTs);

    @Async
    @Query("SELECT new TsKvEntity(AVG(tskv.longValue), AVG(tskv.doubleValue)) FROM TsKvEntity tskv " +
            "WHERE tskv.entityId = :entityId AND tskv.entityType = :entityType " +
            "AND tskv.key = :entityKey AND tskv.ts > :startTs AND tskv.ts < :endTs")
    CompletableFuture<TsKvEntity> findAvg(@Param("entityId") String entityId,
                       @Param("entityType") EntityType entityType,
                       @Param("entityKey") String entityKey,
                       @Param("startTs") long startTs,
                       @Param("endTs") long endTs);


    @Async
    @Query("SELECT new TsKvEntity(SUM(tskv.longValue), SUM(tskv.doubleValue)) FROM TsKvEntity tskv " +
            "WHERE tskv.entityId = :entityId AND tskv.entityType = :entityType " +
            "AND tskv.key = :entityKey AND tskv.ts > :startTs AND tskv.ts < :endTs")
    CompletableFuture<TsKvEntity> findSum(@Param("entityId") String entityId,
                       @Param("entityType") EntityType entityType,
                       @Param("entityKey") String entityKey,
                       @Param("startTs") long startTs,
                       @Param("endTs") long endTs);
}
