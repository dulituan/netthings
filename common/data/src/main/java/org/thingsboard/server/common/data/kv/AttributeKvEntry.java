/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.data.kv;

/**
 * @author Andrew Shvayka
 */
public interface AttributeKvEntry extends KvEntry {

    long getLastUpdateTs();

}
