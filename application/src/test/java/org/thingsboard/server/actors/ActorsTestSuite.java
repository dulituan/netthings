/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.actors;

import org.junit.extensions.cpsuite.ClasspathSuite;
import org.junit.runner.RunWith;

/**
 * @author Andrew Shvayka
 */
@RunWith(ClasspathSuite.class)
@ClasspathSuite.ClassnameFilters({"org.thingsboard.server.actors.*Test"})
public class ActorsTestSuite {
}
