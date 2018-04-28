/**
 *
 */
package org.thingsboard.server.actors.service;

import akka.actor.UntypedActor;
import org.thingsboard.server.actors.ActorSystemContext;

public abstract class ContextAwareActor extends UntypedActor {

    public static final int ENTITY_PACK_LIMIT = 1024;

    protected final ActorSystemContext systemContext;

    public ContextAwareActor(ActorSystemContext systemContext) {
        super();
        this.systemContext = systemContext;
    }
}
