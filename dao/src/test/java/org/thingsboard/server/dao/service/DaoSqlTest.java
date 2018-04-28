/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.service;

import org.springframework.test.context.TestPropertySource;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@TestPropertySource(locations = {"classpath:application-test.properties", "classpath:sql-test.properties"})
public @interface DaoSqlTest {
}
