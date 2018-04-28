/**
 *
 */
package org.thingsboard.server.common.data.id;

import java.io.Serializable;

public interface SessionId extends Serializable {

    String toUidStr();

}
