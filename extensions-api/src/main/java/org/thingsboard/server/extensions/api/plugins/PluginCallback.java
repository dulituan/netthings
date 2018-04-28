/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.plugins;

/**
 * @author Andrew Shvayka
 */
public interface PluginCallback<T> {

    void onSuccess(PluginContext ctx, T value);

    void onFailure(PluginContext ctx, Exception e);
}
