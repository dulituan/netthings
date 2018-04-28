/**
 *
 */
package org.thingsboard.server.extensions.api.rules;

import com.google.common.util.concurrent.ListenableFuture;
import org.thingsboard.server.common.data.Event;
import org.thingsboard.server.common.data.alarm.Alarm;
import org.thingsboard.server.common.data.alarm.AlarmId;
import org.thingsboard.server.common.data.id.EntityId;
import org.thingsboard.server.common.data.id.RuleId;
import org.thingsboard.server.extensions.api.device.DeviceMetaData;

import java.util.Optional;

public interface RuleContext {

    RuleId getRuleId();

    DeviceMetaData getDeviceMetaData();

    Event save(Event event);

    Optional<Event> saveIfNotExists(Event event);

    Optional<Event> findEvent(String eventType, String eventUid);

    Optional<Alarm> findLatestAlarm(EntityId originator, String alarmType);

    Alarm createOrUpdateAlarm(Alarm alarm);

    ListenableFuture<Boolean> clearAlarm(AlarmId id, long clearTs);
}
