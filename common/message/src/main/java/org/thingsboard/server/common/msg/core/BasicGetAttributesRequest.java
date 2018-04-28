/**
 *
 */
package org.thingsboard.server.common.msg.core;

import lombok.ToString;
import org.thingsboard.server.common.msg.session.MsgType;

import java.util.Collections;
import java.util.Optional;
import java.util.Set;

@ToString
public class BasicGetAttributesRequest extends BasicRequest implements GetAttributesRequest {

    private static final long serialVersionUID = 1L;

    private final Set<String> clientKeys;
    private final Set<String> sharedKeys;

    public BasicGetAttributesRequest(Integer requestId) {
        this(requestId, Collections.emptySet(), Collections.emptySet());
    }

    public BasicGetAttributesRequest(Integer requestId, Set<String> clientKeys, Set<String> sharedKeys) {
        super(requestId);
        this.clientKeys = clientKeys;
        this.sharedKeys = sharedKeys;
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.GET_ATTRIBUTES_REQUEST;
    }

    @Override
    public Optional<Set<String>> getClientAttributeNames() {
        return Optional.ofNullable(clientKeys);
    }

    @Override
    public Optional<Set<String>> getSharedAttributeNames() {
        return Optional.ofNullable(sharedKeys);
    }

}
