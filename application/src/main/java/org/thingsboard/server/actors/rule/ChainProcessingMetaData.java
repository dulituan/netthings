/**
 *
 */
package org.thingsboard.server.actors.rule;

import akka.actor.ActorRef;
import org.thingsboard.server.common.msg.device.ToDeviceActorMsg;
import org.thingsboard.server.extensions.api.device.DeviceMetaData;

/**
 * Immutable part of chain processing data;
 *
 * @author ashvayka
 */
public final class ChainProcessingMetaData {

    final RuleActorChain chain;
    final ToDeviceActorMsg inMsg;
    final ActorRef originator;
    final DeviceMetaData deviceMetaData;

    public ChainProcessingMetaData(RuleActorChain chain, ToDeviceActorMsg inMsg, DeviceMetaData deviceMetaData, ActorRef originator) {
        super();
        this.chain = chain;
        this.inMsg = inMsg;
        this.originator = originator;
        this.deviceMetaData = deviceMetaData;
    }
}
