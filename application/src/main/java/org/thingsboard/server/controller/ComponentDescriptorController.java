/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.exception.ThingsboardException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ComponentDescriptorController extends BaseController {

    @PreAuthorize("hasAnyAuthority('SYS_ADMIN','TENANT_ADMIN')")
    @RequestMapping(value = "/component/{componentDescriptorClazz:.+}", method = RequestMethod.GET)
    @ResponseBody
    public ComponentDescriptor getComponentDescriptorByClazz(@PathVariable("componentDescriptorClazz") String strComponentDescriptorClazz) throws ThingsboardException {
        checkParameter("strComponentDescriptorClazz", strComponentDescriptorClazz);
        try {
            return checkComponentDescriptorByClazz(strComponentDescriptorClazz);
        } catch (Exception e) {
            throw handleException(e);
        }
    }

    @PreAuthorize("hasAnyAuthority('SYS_ADMIN','TENANT_ADMIN')")
    @RequestMapping(value = "/components/{componentType}", method = RequestMethod.GET)
    @ResponseBody
    public List<ComponentDescriptor> getComponentDescriptorsByType(@PathVariable("componentType") String strComponentType) throws ThingsboardException {
        checkParameter("componentType", strComponentType);
        try {
            return checkComponentDescriptorsByType(ComponentType.valueOf(strComponentType));
        } catch (Exception e) {
            throw handleException(e);
        }
    }

    @PreAuthorize("hasAnyAuthority('SYS_ADMIN','TENANT_ADMIN')")
    @RequestMapping(value = "/components/actions/{pluginClazz:.+}", method = RequestMethod.GET)
    @ResponseBody
    public List<ComponentDescriptor> getPluginActionsByPluginClazz(@PathVariable("pluginClazz") String pluginClazz) throws ThingsboardException {
        checkParameter("pluginClazz", pluginClazz);
        try {
            return checkPluginActionsByPluginClazz(pluginClazz);
        } catch (Exception e) {
            throw handleException(e);
        }
    }

}
