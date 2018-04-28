/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport.quota;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public class ClockTest {

    @Before
    public void init() {
        Clock.reset();
    }

    @After
    public void clear() {
        Clock.reset();
    }

    @Test
    public void defaultClockUseSystemTime() {
        assertFalse(Clock.millis() > System.currentTimeMillis());
    }

    @Test
    public void timeCanBeSet() {
        Clock.setMillis(100L);
        assertEquals(100L, Clock.millis());
    }

    @Test
    public void clockCanBeReseted() {
        Clock.setMillis(100L);
        assertEquals(100L, Clock.millis());
        Clock.reset();
        assertFalse(Clock.millis() > System.currentTimeMillis());
    }

    @Test
    public void timeIsShifted() {
        Clock.setMillis(100L);
        Clock.shift(50L);
        assertEquals(150L, Clock.millis());
    }

}