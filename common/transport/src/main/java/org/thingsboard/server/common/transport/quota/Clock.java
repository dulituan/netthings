/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport.quota;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public final class Clock {

    private static long time = 0L;

    private Clock() {
    }


    public static long millis() {
        return time == 0 ? System.currentTimeMillis() : time;
    }

    public static void setMillis(long millis) {
        time = millis;
    }

    public static void shift(long delta) {
        time += delta;
    }

    public static void reset() {
        time = 0;
    }
}
