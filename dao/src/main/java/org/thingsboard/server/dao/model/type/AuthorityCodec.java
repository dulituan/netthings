/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.model.type;

import com.datastax.driver.extras.codecs.enums.EnumNameCodec;
import org.thingsboard.server.common.data.security.Authority;

public class AuthorityCodec extends EnumNameCodec<Authority> {

    public AuthorityCodec() {
        super(Authority.class);
    }

}
