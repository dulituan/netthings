/**
 *
 */
package org.thingsboard.server.extensions.core.processor;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class AlarmDeduplicationProcessorConfiguration {

    private String alarmIdTemplate;
    private String alarmBodyTemplate;

}
