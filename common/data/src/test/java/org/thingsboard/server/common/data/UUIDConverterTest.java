/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.data;

import com.datastax.driver.core.utils.UUIDs;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Random;
import java.util.UUID;

/**
 * Created by ashvayka on 14.07.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class UUIDConverterTest {

    @Test
    public void basicUuidToStringTest() {
        UUID original = UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66");
        String result = UUIDConverter.fromTimeUUID(original);
        Assert.assertEquals("1d8eebc58e0a7d796690800200c9a66", result);
    }

    @Test
    public void basicStringToUUIDTest() {
        UUID result = UUIDConverter.fromString("1d8eebc58e0a7d796690800200c9a66");
        Assert.assertEquals(UUID.fromString("58e0a7d7-eebc-11d8-9669-0800200c9a66"), result);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nonV1UuidToStringTest() {
        UUIDConverter.fromTimeUUID(UUID.fromString("58e0a7d7-eebc-01d8-9669-0800200c9a66"));
    }

    @Test
    public void basicUuidComperisonTest() {
        Random r = new Random(System.currentTimeMillis());
        for (int i = 0; i < 100000; i++) {
            long ts = System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 365 * 10;
            long before = (long) (Math.random() * ts);
            long after = (long) (Math.random() * ts);
            if (before > after) {
                long tmp = after;
                after = before;
                before = tmp;
            }

            String beforeStr = UUIDConverter.fromTimeUUID(UUIDs.startOf(before));
            String afterStr = UUIDConverter.fromTimeUUID(UUIDs.startOf(after));

            if (afterStr.compareTo(beforeStr) < 0) {
                System.out.println("Before: " + before + " | " + beforeStr);
                System.out.println("After: " + after + " | " + afterStr);
            }
            Assert.assertTrue(afterStr.compareTo(beforeStr) >= 0);
        }
    }


}
