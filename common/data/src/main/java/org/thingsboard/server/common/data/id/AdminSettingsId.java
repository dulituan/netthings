/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.common.data.id;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AdminSettingsId extends UUIDBased {

    @JsonCreator
    public AdminSettingsId(@JsonProperty("id") UUID id){
        super(id);
    }
    
}
