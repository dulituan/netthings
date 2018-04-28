/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.model;

import java.io.Serializable;
import java.util.UUID;

public interface BaseEntity<D> extends ToData<D> {

    UUID getId();

    void setId(UUID id);

}
