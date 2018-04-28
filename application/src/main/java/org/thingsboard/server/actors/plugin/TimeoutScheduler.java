/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors.plugin;

import akka.actor.ActorRef;

/**
 * @author Andrew Shvayka
 */
public interface TimeoutScheduler {

    void scheduleMsgWithDelay(Object msg, long delayInMs);

}
