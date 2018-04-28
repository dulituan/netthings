/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.util;

import com.google.common.util.concurrent.ListenableFuture;

public interface AsyncRateLimiter {

    ListenableFuture<Void> acquireAsync();

    void release();
}
