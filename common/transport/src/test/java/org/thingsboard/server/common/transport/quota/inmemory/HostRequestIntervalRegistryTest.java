/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.transport.quota.inmemory;

import com.google.common.collect.Sets;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;

import static org.junit.Assert.assertEquals;

/**
 * @author Vitaliy Paromskiy
 * @version 1.0
 */
public class HostRequestIntervalRegistryTest {

    private HostRequestIntervalRegistry registry;

    @Before
    public void init() {
        registry = new HostRequestIntervalRegistry(10000L, 100L,"g1,g2", "b1");
    }

    @Test
    public void newHostCreateNewInterval() {
        assertEquals(1L, registry.tick("host1"));
    }

    @Test
    public void existingHostUpdated() {
        registry.tick("aaa");
        assertEquals(1L, registry.tick("bbb"));
        assertEquals(2L, registry.tick("aaa"));
    }

    @Test
    public void expiredIntervalsCleaned() throws InterruptedException {
        registry.tick("aaa");
        Thread.sleep(150L);
        registry.tick("bbb");
        registry.clean();
        assertEquals(1L, registry.tick("aaa"));
        assertEquals(2L, registry.tick("bbb"));
    }

    @Test
    public void domainFromWhitelistNotCounted(){
        assertEquals(0L, registry.tick("g1"));
        assertEquals(0L, registry.tick("g1"));
        assertEquals(0L, registry.tick("g2"));
    }

    @Test
    public void domainFromBlackListReturnMaxValue(){
        assertEquals(Long.MAX_VALUE, registry.tick("b1"));
        assertEquals(Long.MAX_VALUE, registry.tick("b1"));
    }

    @Test
    public void emptyWhitelistParsedOk(){
        registry = new HostRequestIntervalRegistry(10000L, 100L,"", "b1");
        assertEquals(1L, registry.tick("aaa"));
    }

    @Test
    public void emptyBlacklistParsedOk(){
        registry = new HostRequestIntervalRegistry(10000L, 100L,"", "");
        assertEquals(1L, registry.tick("aaa"));
    }
}