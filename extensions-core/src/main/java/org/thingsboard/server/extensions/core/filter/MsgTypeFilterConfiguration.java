/**
 *
 */
package org.thingsboard.server.extensions.core.filter;

import lombok.Data;

/**
 * @author Andrew Shvayka
 */
@Data
public class MsgTypeFilterConfiguration {

    private String[] messageTypes;

}
