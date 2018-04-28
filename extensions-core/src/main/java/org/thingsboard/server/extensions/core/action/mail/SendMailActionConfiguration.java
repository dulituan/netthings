/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.core.action.mail;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class SendMailActionConfiguration {

    private String sendFlag;

    private String fromTemplate;
    private String toTemplate;
    private String ccTemplate;
    private String bccTemplate;
    private String subjectTemplate;
    private String bodyTemplate;
}
