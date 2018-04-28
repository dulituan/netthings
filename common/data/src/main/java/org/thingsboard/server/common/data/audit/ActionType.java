/**
 *
 */
package org.thingsboard.server.common.data.audit;

import lombok.Getter;

@Getter
public enum ActionType {
    ADDED(false), // log entity
    DELETED(false), // log string id
    UPDATED(false), // log entity
    ATTRIBUTES_UPDATED(false), // log attributes/values
    ATTRIBUTES_DELETED(false), // log attributes
    RPC_CALL(false), // log method and params
    CREDENTIALS_UPDATED(false), // log new credentials
    ASSIGNED_TO_CUSTOMER(false), // log customer name
    UNASSIGNED_FROM_CUSTOMER(false), // log customer name
    ACTIVATED(false), // log string id
    SUSPENDED(false), // log string id
    CREDENTIALS_READ(true), // log device id
    ATTRIBUTES_READ(true); // log attributes

    private final boolean isRead;

    ActionType(boolean isRead) {
        this.isRead = isRead;
    }
}
