/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.service.event;

import com.datastax.driver.core.utils.UUIDs;
import org.junit.Assert;
import org.junit.Test;
import org.thingsboard.server.common.data.DataConstants;
import org.thingsboard.server.common.data.Event;
import org.thingsboard.server.common.data.id.DeviceId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.EventId;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TimePageData;
import org.thingsboard.server.common.data.page.TimePageLink;
import org.thingsboard.server.dao.service.AbstractServiceTest;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.Optional;

public abstract class BaseEventServiceTest extends AbstractServiceTest {

    @Test
    public void saveEvent() throws Exception {
        DeviceId devId = new DeviceId(UUIDs.timeBased());
        Event event = generateEvent(null, devId, "ALARM", UUIDs.timeBased().toString());
        Event saved = eventService.save(event);
        Optional<Event> loaded = eventService.findEvent(event.getTenantId(), event.getEntityId(), event.getType(), event.getUid());
        Assert.assertTrue(loaded.isPresent());
        Assert.assertNotNull(loaded.get());
        Assert.assertEquals(saved, loaded.get());
    }

    @Test
    public void saveEventIfNotExists() throws Exception {
        DeviceId devId = new DeviceId(UUIDs.timeBased());
        Event event = generateEvent(null, devId, "ALARM", UUIDs.timeBased().toString());
        Optional<Event> saved = eventService.saveIfNotExists(event);
        Assert.assertTrue(saved.isPresent());
        saved = eventService.saveIfNotExists(event);
        Assert.assertFalse(saved.isPresent());
    }

    @Test
    public void findEventsByTypeAndTimeAscOrder() throws Exception {
        long timeBeforeStartTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 11, 30).toEpochSecond(ZoneOffset.UTC);
        long startTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 12, 0).toEpochSecond(ZoneOffset.UTC);
        long eventTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 12, 30).toEpochSecond(ZoneOffset.UTC);
        long endTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 13, 0).toEpochSecond(ZoneOffset.UTC);
        long timeAfterEndTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 13, 30).toEpochSecond(ZoneOffset.UTC);

        RuleId ruleId = new RuleId(UUIDs.timeBased());
        TenantId tenantId = new TenantId(UUIDs.timeBased());
        saveEventWithProvidedTime(timeBeforeStartTime, ruleId, tenantId);
        Event savedEvent = saveEventWithProvidedTime(eventTime, ruleId, tenantId);
        Event savedEvent2 = saveEventWithProvidedTime(eventTime+1, ruleId, tenantId);
        Event savedEvent3 = saveEventWithProvidedTime(eventTime+2, ruleId, tenantId);
        saveEventWithProvidedTime(timeAfterEndTime, ruleId, tenantId);

        TimePageData<Event> events = eventService.findEvents(tenantId, ruleId, DataConstants.STATS,
                new TimePageLink(2, startTime, endTime, true));

        Assert.assertNotNull(events.getData());
        Assert.assertTrue(events.getData().size() == 2);
        Assert.assertTrue(events.getData().get(0).getUuidId().equals(savedEvent.getUuidId()));
        Assert.assertTrue(events.getData().get(1).getUuidId().equals(savedEvent2.getUuidId()));
        Assert.assertTrue(events.hasNext());
        Assert.assertNotNull(events.getNextPageLink());

        events = eventService.findEvents(tenantId, ruleId, DataConstants.STATS, events.getNextPageLink());

        Assert.assertNotNull(events.getData());
        Assert.assertTrue(events.getData().size() == 1);
        Assert.assertTrue(events.getData().get(0).getUuidId().equals(savedEvent3.getUuidId()));
        Assert.assertFalse(events.hasNext());
        Assert.assertNull(events.getNextPageLink());
    }

    @Test
    public void findEventsByTypeAndTimeDescOrder() throws Exception {
        long timeBeforeStartTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 11, 30).toEpochSecond(ZoneOffset.UTC);
        long startTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 12, 0).toEpochSecond(ZoneOffset.UTC);
        long eventTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 12, 30).toEpochSecond(ZoneOffset.UTC);
        long endTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 13, 0).toEpochSecond(ZoneOffset.UTC);
        long timeAfterEndTime = LocalDateTime.of(2016, Month.NOVEMBER, 1, 13, 30).toEpochSecond(ZoneOffset.UTC);

        RuleId ruleId = new RuleId(UUIDs.timeBased());
        TenantId tenantId = new TenantId(UUIDs.timeBased());
        saveEventWithProvidedTime(timeBeforeStartTime, ruleId, tenantId);
        Event savedEvent = saveEventWithProvidedTime(eventTime, ruleId, tenantId);
        Event savedEvent2 = saveEventWithProvidedTime(eventTime+1, ruleId, tenantId);
        Event savedEvent3 = saveEventWithProvidedTime(eventTime+2, ruleId, tenantId);
        saveEventWithProvidedTime(timeAfterEndTime, ruleId, tenantId);

        TimePageData<Event> events = eventService.findEvents(tenantId, ruleId, DataConstants.STATS,
                new TimePageLink(2, startTime, endTime, false));

        Assert.assertNotNull(events.getData());
        Assert.assertTrue(events.getData().size() == 2);
        Assert.assertTrue(events.getData().get(0).getUuidId().equals(savedEvent3.getUuidId()));
        Assert.assertTrue(events.getData().get(1).getUuidId().equals(savedEvent2.getUuidId()));
        Assert.assertTrue(events.hasNext());
        Assert.assertNotNull(events.getNextPageLink());

        events = eventService.findEvents(tenantId, ruleId, DataConstants.STATS, events.getNextPageLink());

        Assert.assertNotNull(events.getData());
        Assert.assertTrue(events.getData().size() == 1);
        Assert.assertTrue(events.getData().get(0).getUuidId().equals(savedEvent.getUuidId()));
        Assert.assertFalse(events.hasNext());
        Assert.assertNull(events.getNextPageLink());
    }

    private Event saveEventWithProvidedTime(long time, EntityId entityId, TenantId tenantId) throws IOException {
        Event event = generateEvent(tenantId, entityId, DataConstants.STATS, null);
        event.setId(new EventId(UUIDs.startOf(time)));
        return eventService.save(event);
    }
}