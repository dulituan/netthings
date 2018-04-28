/**
 *
 */
package org.thingsboard.server.extensions.core.processor;

import lombok.Data;

import java.util.List;

/**
 * @author Andrew Shvayka
 */
@Data
public class AlarmProcessorConfiguration {

    private String newAlarmExpression;
    private String clearAlarmExpression;

    private String alarmTypeTemplate;
    private String alarmSeverity;
    private String alarmStatus;
    private boolean alarmPropagateFlag;
    private boolean newAlarmFlag;

    private String alarmDetailsTemplate;

}