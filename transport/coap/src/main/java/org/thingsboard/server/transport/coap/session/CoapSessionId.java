/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.transport.coap.session;

import org.thingsboard.server.common.data.id.SessionId;

public final class CoapSessionId implements SessionId {

    private final String clientAddress;
    private final int clientPort;
    private final String token;

    public CoapSessionId(String host, int port, String token) {
        super();
        this.clientAddress = host;
        this.clientPort = port;
        this.token = token;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((clientAddress == null) ? 0 : clientAddress.hashCode());
        result = prime * result + clientPort;
        result = prime * result + ((token == null) ? 0 : token.hashCode());
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
        CoapSessionId other = (CoapSessionId) obj;
        if (clientAddress == null) {
            if (other.clientAddress != null)
                return false;
        } else if (!clientAddress.equals(other.clientAddress))
            return false;
        if (clientPort != other.clientPort)
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CoapSessionId [clientAddress=" + clientAddress + ", clientPort=" + clientPort + ", token=" + token + "]";
    }

    @Override
    public String toUidStr() {
        return clientAddress + ":" + clientPort + ":" + token;
    }

}
