/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.controller;

import org.junit.ClassRule;
import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;
import org.thingsboard.server.dao.CustomSqlUnit;

import java.util.Arrays;

@RunWith(ClasspathSuite.class)
@ClasspathSuite.ClassnameFilters({
        "org.thingsboard.server.controller.sql.*SqlTest",
        })
public class ControllerSqlTestSuite {

    @ClassRule
    public static CustomSqlUnit sqlUnit = new CustomSqlUnit(
            Arrays.asList("sql/schema.sql", "sql/system-data.sql"),
            "sql/drop-all-tables.sql",
            "sql-test.properties");
}
