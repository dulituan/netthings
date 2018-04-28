/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.api.component;

import org.thingsboard.server.common.data.plugin.ComponentScope;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Andrew Shvayka
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Processor {

    String name();

    ComponentScope scope() default ComponentScope.TENANT;

    String descriptor() default "EmptyJsonDescriptor.json";

    Class<?> configuration() default EmptyComponentConfiguration.class;

}
