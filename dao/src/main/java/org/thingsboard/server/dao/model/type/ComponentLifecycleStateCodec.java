/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.model.type;

import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import org.thingsboard.server.common.data.plugin.ComponentLifecycleState;

public class ComponentLifecycleStateCodec extends EnumNameCodec<ComponentLifecycleState> {

    public ComponentLifecycleStateCodec() {
        super(ComponentLifecycleState.class);
    }

}
