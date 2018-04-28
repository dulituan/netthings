/**
 *
 */
package org.thingsboard.server.common.msg.session;

/**
 * @author Andrew Shvayka
 */
public interface FromDeviceRequestMsg extends FromDeviceMsg {

    Integer getRequestId();

}
