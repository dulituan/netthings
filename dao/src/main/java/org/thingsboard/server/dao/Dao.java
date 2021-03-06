/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao;

import com.google.common.util.concurrent.ListenableFuture;

import java.util.List;
import java.util.UUID;

public interface Dao<T> {

    List<T> find();

    T findById(UUID id);

    ListenableFuture<T> findByIdAsync(UUID id);

    T save(T t);

    boolean removeById(UUID id);

}
