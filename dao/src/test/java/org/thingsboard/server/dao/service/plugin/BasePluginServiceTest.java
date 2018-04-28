/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.service.plugin;

import com.datastax.driver.core.utils.UUIDs;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.thingsboard.server.common.data.id.TenantId;
import org.thingsboard.server.common.data.page.TextPageData;
import org.thingsboard.server.common.data.page.TextPageLink;
import org.thingsboard.server.common.data.plugin.PluginMetaData;
import org.thingsboard.server.dao.model.ModelConstants;
import org.thingsboard.server.dao.service.AbstractServiceTest;

import java.util.UUID;

@Slf4j
public abstract class BasePluginServiceTest extends AbstractServiceTest {

  @Test
  public void savePlugin() throws Exception {
    PluginMetaData pluginMetaData = pluginService.savePlugin(generatePlugin(null, null));
    Assert.assertNotNull(pluginMetaData.getId());
    Assert.assertNotNull(pluginMetaData.getAdditionalInfo());

    pluginMetaData.setAdditionalInfo(mapper.readTree("{\"description\":\"test\"}"));
    PluginMetaData newPluginMetaData = pluginService.savePlugin(pluginMetaData);
    Assert.assertEquals(pluginMetaData.getAdditionalInfo(), newPluginMetaData.getAdditionalInfo());

  }

  @Test
  public void findPluginById() throws Exception {
    PluginMetaData expected = pluginService.savePlugin(generatePlugin(null, null));
    Assert.assertNotNull(expected.getId());
    PluginMetaData found = pluginService.findPluginById(expected.getId());
    Assert.assertEquals(expected, found);
  }

  @Test
  public void findPluginByTenantIdAndApiToken() throws Exception {
    String token = UUID.randomUUID().toString();
    TenantId tenantId = new TenantId(UUIDs.timeBased());
    pluginService.savePlugin(generatePlugin(null, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    PluginMetaData expected = pluginService.savePlugin(generatePlugin(tenantId, token));
    Assert.assertNotNull(expected.getId());
    PluginMetaData found = pluginService.findPluginByApiToken(token);
    Assert.assertEquals(expected, found);
  }

  @Test
  public void findSystemPlugins() throws Exception {
    TenantId systemTenant = new TenantId(ModelConstants.NULL_UUID); // system tenant id
    pluginService.savePlugin(generatePlugin(null, null));
    pluginService.savePlugin(generatePlugin(null, null));
    pluginService.savePlugin(generatePlugin(systemTenant, null));
    pluginService.savePlugin(generatePlugin(systemTenant, null));
    TextPageData<PluginMetaData> found = pluginService.findSystemPlugins(new TextPageLink(100));
    Assert.assertEquals(2, found.getData().size());
    Assert.assertFalse(found.hasNext());
  }

  @Test
  public void findTenantPlugins() throws Exception {
    TenantId tenantId = new TenantId(UUIDs.timeBased());
    pluginService.savePlugin(generatePlugin(null, null));
    pluginService.savePlugin(generatePlugin(null, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    TextPageData<PluginMetaData> found = pluginService.findTenantPlugins(tenantId, new TextPageLink(100));
    Assert.assertEquals(3, found.getData().size());
  }

  @Test
  public void deletePluginById() throws Exception {
    PluginMetaData expected = pluginService.savePlugin(generatePlugin(null, null));
    Assert.assertNotNull(expected.getId());
    pluginService.deletePluginById(expected.getId());
    PluginMetaData found = pluginService.findPluginById(expected.getId());
    Assert.assertNull(found);
  }

  @Test
  public void deletePluginsByTenantId() throws Exception {
    TenantId tenantId = new TenantId(UUIDs.timeBased());
    pluginService.savePlugin(generatePlugin(tenantId, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    pluginService.savePlugin(generatePlugin(tenantId, null));
    TextPageData<PluginMetaData> found = pluginService.findTenantPlugins(tenantId, new TextPageLink(100));
    Assert.assertEquals(3, found.getData().size());
    pluginService.deletePluginsByTenantId(tenantId);
    found = pluginService.findTenantPlugins(tenantId, new TextPageLink(100));
    Assert.assertEquals(0, found.getData().size());
  }

}