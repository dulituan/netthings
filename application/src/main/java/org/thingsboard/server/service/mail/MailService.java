/**
 *
 */
package org.thingsboard.server.service.mail;

import org.thingsboard.server.exception.ThingsboardException;

import com.fasterxml.jackson.databind.JsonNode;

public interface MailService {

    void updateMailConfiguration();

    void sendEmail(String email, String subject, String message) throws ThingsboardException;
    
    void sendTestMail(JsonNode config, String email) throws ThingsboardException;
    
    void sendActivationEmail(String activationLink, String email) throws ThingsboardException;
    
    void sendAccountActivatedEmail(String loginLink, String email) throws ThingsboardException;
    
    void sendResetPasswordEmail(String passwordResetLink, String email) throws ThingsboardException;
    
    void sendPasswordWasResetEmail(String loginLink, String email) throws ThingsboardException;
    
}
