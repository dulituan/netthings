/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.timeseries;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvQuery;

import java.util.List;

/**
 * @author Andrew Shvayka
 */
public interface TimeseriesDao {

    ListenableFuture<List<TsKvEntry>> findAllAsync(EntityId entityId, List<TsKvQuery> queries);

    ListenableFuture<TsKvEntry> findLatest(EntityId entityId, String key);

    ListenableFuture<List<TsKvEntry>> findAllLatest(EntityId entityId);

    ListenableFuture<Void> save(EntityId entityId, TsKvEntry tsKvEntry, long ttl);

    ListenableFuture<Void> savePartition(EntityId entityId, long tsKvEntryTs, String key, long ttl);

    ListenableFuture<Void> saveLatest(EntityId entityId, TsKvEntry tsKvEntry);
}
