/**
 *
 */
package org.thingsboard.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.thingsboard.server.common.data.Tenant;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TextPageData;
import org.thingsboard.server.common.data.page.TextPageLink;
import org.thingsboard.server.dao.tenant.TenantService;
import org.thingsboard.server.exception.ThingsboardException;

@RestController
@RequestMapping("/api")
public class TenantController extends BaseController {
    
    @Autowired
    private TenantService tenantService;

    @PreAuthorize("hasAnyAuthority('SYS_ADMIN', 'TENANT_ADMIN')")
    @RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.GET)
    @ResponseBody
    public Tenant getTenantById(@PathVariable("tenantId") String strTenantId) throws ThingsboardException {
        checkParameter("tenantId", strTenantId);
        try {
            TenantId tenantId = new TenantId(toUUID(strTenantId));
            checkTenantId(tenantId);
            return checkNotNull(tenantService.findTenantById(tenantId));
        } catch (Exception e) {
            throw handleException(e);
        }
    }

    @PreAuthorize("hasAuthority('SYS_ADMIN')")
    @RequestMapping(value = "/tenant", method = RequestMethod.POST)
    @ResponseBody 
    public Tenant saveTenant(@RequestBody Tenant tenant) throws ThingsboardException {
        try {
            return checkNotNull(tenantService.saveTenant(tenant));
        } catch (Exception e) {
            throw handleException(e);
        }
    }

    @PreAuthorize("hasAuthority('SYS_ADMIN')")
    @RequestMapping(value = "/tenant/{tenantId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deleteTenant(@PathVariable("tenantId") String strTenantId) throws ThingsboardException {
        checkParameter("tenantId", strTenantId);
        try {
            TenantId tenantId = new TenantId(toUUID(strTenantId));
            tenantService.deleteTenant(tenantId);
        } catch (Exception e) {
            throw handleException(e);
        }
    }

    @PreAuthorize("hasAuthority('SYS_ADMIN')")
    @RequestMapping(value = "/tenants", params = { "limit" }, method = RequestMethod.GET)
    @ResponseBody
    public TextPageData<Tenant> getTenants(@RequestParam int limit,
                                           @RequestParam(required = false) String textSearch,
                                           @RequestParam(required = false) String idOffset,
                                           @RequestParam(required = false) String textOffset) throws ThingsboardException {
        try {
            TextPageLink pageLink = createPageLink(limit, textSearch, idOffset, textOffset);
            return checkNotNull(tenantService.findTenants(pageLink));
        } catch (Exception e) {
            throw handleException(e);
        }
    }
    
}
