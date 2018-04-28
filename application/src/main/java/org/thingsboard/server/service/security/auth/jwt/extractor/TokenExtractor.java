/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.service.security.auth.jwt.extractor;

import javax.servlet.http.HttpServletRequest;

public interface TokenExtractor {
    public String extract(HttpServletRequest request);
}