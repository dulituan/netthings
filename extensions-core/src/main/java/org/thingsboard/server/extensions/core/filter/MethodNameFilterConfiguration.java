/**
 *
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class MethodNameFilterConfiguration {

    private MethodName[] methodNames;

    @Data
    public static class MethodName {
        private String name;
    }

}
