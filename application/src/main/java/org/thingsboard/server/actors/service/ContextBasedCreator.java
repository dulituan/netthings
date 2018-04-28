/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.service;

import org.thingsboard.server.actors.ActorSystemContext;

import akka.japi.Creator;

public abstract class ContextBasedCreator<T> implements Creator<T> {

    private static final long serialVersionUID = 1L;

    protected final transient ActorSystemContext context;

    public ContextBasedCreator(ActorSystemContext context) {
        super();
        this.context = context;
    }
}
