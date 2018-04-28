/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.shared;

import akka.actor.ActorContext;
import akka.event.LoggingAdapter;
import org.thingsboard.server.actors.ActorSystemContext;
import org.thingsboard.server.actors.stats.StatsPersistTick;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.msg.cluster.ClusterEventMsg;

public abstract class ComponentMsgProcessor<T> extends AbstractContextAwareMsgProcessor {

    protected final TenantId tenantId;
    protected final T entityId;

    protected ComponentMsgProcessor(ActorSystemContext systemContext, LoggingAdapter logger, TenantId tenantId, T id) {
        super(systemContext, logger);
        this.tenantId = tenantId;
        this.entityId = id;
    }

    public abstract void start() throws Exception;

    public abstract void stop() throws Exception;

    public abstract void onCreated(ActorContext context) throws Exception;

    public abstract void onUpdate(ActorContext context) throws Exception;

    public abstract void onActivate(ActorContext context) throws Exception;

    public abstract void onSuspend(ActorContext context) throws Exception;

    public abstract void onStop(ActorContext context) throws Exception;

    public abstract void onClusterEventMsg(ClusterEventMsg msg) throws Exception;

    public void scheduleStatsPersistTick(ActorContext context, long statsPersistFrequency) {
        schedulePeriodicMsgWithDelay(context, new StatsPersistTick(), statsPersistFrequency, statsPersistFrequency);
    }
}
