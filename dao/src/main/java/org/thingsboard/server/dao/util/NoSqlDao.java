/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.util;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(prefix = "database", value = "type", havingValue = "cassandra")
public @interface NoSqlDao {
}
