/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.extensions.sns.plugin;

import lombok.Data;

/**
 * Created by Valerii Sosliuk on 11/5/2017.
 */
@Data
public class SnsPluginConfiguration {

    private String accessKeyId;
    private String secretAccessKey;
    private String region;

}
