/**
 *
 */
package org.thingsboard.server.extensions.api.plugins.msg;

/**
 * @author Andrew Shvayka
 */
public final class TimeoutIntMsg extends TimeoutMsg<Integer> {

    public TimeoutIntMsg(Integer id, long timeout) {
        super(id, timeout);
    }

}
