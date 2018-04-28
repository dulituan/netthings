/**
 *
 */
package org.thingsboard.server.common.msg.core;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

import org.thingsboard.server.common.data.kv.AttributeKvEntry;
import org.thingsboard.server.common.msg.session.MsgType;

public class BasicUpdateAttributesRequest extends BasicRequest implements UpdateAttributesRequest {

    private static final long serialVersionUID = 1L;

    private final Set<AttributeKvEntry> data;

    public BasicUpdateAttributesRequest() {
        this(DEFAULT_REQUEST_ID);
    }

    public BasicUpdateAttributesRequest(Integer requestId) {
        super(requestId);
        this.data = new LinkedHashSet<>();
    }

    public void add(AttributeKvEntry entry) {
        this.data.add(entry);
    }

    public void add(Collection<AttributeKvEntry> entries) {
        this.data.addAll(entries);
    }

    @Override
    public MsgType getMsgType() {
        return MsgType.POST_ATTRIBUTES_REQUEST;
    }

    @Override
    public Set<AttributeKvEntry> getAttributes() {
        return data;
    }

    @Override
    public String toString() {
        return "BasicUpdateAttributesRequest [data=" + data + "]";
    }

}
