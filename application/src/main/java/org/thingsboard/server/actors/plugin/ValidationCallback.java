/**
 *
 */
package org.thingsboard.server.actors.plugin;

import com.hazelcast.util.function.Consumer;
import org.thingsboard.server.extensions.api.exception.AccessDeniedException;
import org.thingsboard.server.extensions.api.exception.EntityNotFoundException;
import org.thingsboard.server.extensions.api.exception.InternalErrorException;
import org.thingsboard.server.extensions.api.exception.UnauthorizedException;
import org.thingsboard.server.extensions.api.plugins.PluginCallback;
import org.thingsboard.server.extensions.api.plugins.PluginContext;

/**
 * Created by ashvayka on 21.02.17.
 */
public class ValidationCallback implements PluginCallback<ValidationResult> {

    private final PluginCallback<?> callback;
    private final Consumer<PluginContext> action;

    public ValidationCallback(PluginCallback<?> callback, Consumer<PluginContext> action) {
        this.callback = callback;
        this.action = action;
    }

    @Override
    public void onSuccess(PluginContext ctx, ValidationResult result) {
        ValidationResultCode resultCode = result.getResultCode();
        if (resultCode == ValidationResultCode.OK) {
            action.accept(ctx);
        } else {
            Exception e;
            switch (resultCode) {
                case ENTITY_NOT_FOUND:
                    e = new EntityNotFoundException(result.getMessage());
                    break;
                case UNAUTHORIZED:
                    e = new UnauthorizedException(result.getMessage());
                    break;
                case ACCESS_DENIED:
                    e = new AccessDeniedException(result.getMessage());
                    break;
                case INTERNAL_ERROR:
                    e = new InternalErrorException(result.getMessage());
                    break;
                default:
                    e = new UnauthorizedException("Permission denied.");
                    break;
            }
            onFailure(ctx, e);
        }
    }

    @Override
    public void onFailure(PluginContext ctx, Exception e) {
        callback.onFailure(ctx, e);
    }
}
