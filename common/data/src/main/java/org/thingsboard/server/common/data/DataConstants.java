/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.data;

/**
 * @author Andrew Shvayka
 */
public class DataConstants {

    public static final String SYSTEM = "SYSTEM";
    public static final String TENANT = "TENANT";
    public static final String CUSTOMER = "CUSTOMER";
    public static final String DEVICE = "DEVICE";

    public static final String CLIENT_SCOPE = "CLIENT_SCOPE";
    public static final String SERVER_SCOPE = "SERVER_SCOPE";
    public static final String SHARED_SCOPE = "SHARED_SCOPE";

    public static final String[] allScopes() {
        return new String[]{CLIENT_SCOPE, SHARED_SCOPE, SERVER_SCOPE};
    }

    public static final String ALARM = "ALARM";
    public static final String ERROR = "ERROR";
    public static final String LC_EVENT = "LC_EVENT";
    public static final String STATS = "STATS";

    public static final String ONEWAY = "ONEWAY";
    public static final String TWOWAY = "TWOWAY";
}
