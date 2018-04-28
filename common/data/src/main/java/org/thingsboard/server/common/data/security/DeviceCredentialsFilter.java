/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.data.security;

/**
 * TODO: This is a temporary name. DeviceCredentialsId is resereved in dao layer
 */
public interface DeviceCredentialsFilter {

    String getCredentialsId();

    DeviceCredentialsType getCredentialsType();

}
