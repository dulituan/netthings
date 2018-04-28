/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.timeseries;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.kv.TsKvEntry;
import org.thingsboard.server.common.data.kv.TsKvQuery;

import java.util.Collection;
import java.util.List;

/**
 * @author Andrew Shvayka
 */
public interface TimeseriesService {

    ListenableFuture<List<TsKvEntry>> findAll(EntityId entityId, List<TsKvQuery> queries);

    ListenableFuture<List<TsKvEntry>> findLatest(EntityId entityId, Collection<String> keys);

    ListenableFuture<List<TsKvEntry>> findAllLatest(EntityId entityId);

    ListenableFuture<List<Void>> save(EntityId entityId, TsKvEntry tsKvEntry);

    ListenableFuture<List<Void>> save(EntityId entityId, List<TsKvEntry> tsKvEntry, long ttl);
}
