/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebConfig {

    @RequestMapping(value = "/{path:^(?!api$)(?!static$)(?!webjars$)[^\\.]*}/**")
    public String redirect() {
        return "forward:/index.html";
    }

}
