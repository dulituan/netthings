/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors;

import org.thingsboard.server.common.data.id.SessionId;

public class DummySessionID implements SessionId {

    @Override
    public String toString() {
        return id;
    }

    private final String id;
    
    public DummySessionID(String id) {
        this.id = id;
    }
    
    @Override
    public String toUidStr() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DummySessionID other = (DummySessionID) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

}
