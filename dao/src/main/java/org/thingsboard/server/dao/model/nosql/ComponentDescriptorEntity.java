/**
 * Copyright © 2016-2018 dujoy.cn
 */
package org.thingsboard.server.dao.model.nosql;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;
import com.fasterxml.jackson.databind.JsonNode;
import org.thingsboard.server.common.data.id.ComponentDescriptorId;
import org.thingsboard.server.common.data.plugin.ComponentDescriptor;
import org.thingsboard.server.common.data.plugin.ComponentScope;
import org.thingsboard.server.common.data.plugin.ComponentType;
import org.thingsboard.server.dao.model.SearchTextEntity;
import org.thingsboard.server.dao.model.type.JsonCodec;

import java.util.UUID;

import static org.thingsboard.server.dao.model.ModelConstants.*;

/**
 * @author Andrew Shvayka
 */
@Table(name = COMPONENT_DESCRIPTOR_COLUMN_FAMILY_NAME)
public class ComponentDescriptorEntity implements SearchTextEntity<ComponentDescriptor> {

    @PartitionKey
    @Column(name = ID_PROPERTY)
    private UUID id;

    @Column(name = COMPONENT_DESCRIPTOR_TYPE_PROPERTY)
    private ComponentType type;

    @Column(name = COMPONENT_DESCRIPTOR_SCOPE_PROPERTY)
    private ComponentScope scope;

    @Column(name = COMPONENT_DESCRIPTOR_NAME_PROPERTY)
    private String name;

    @Column(name = COMPONENT_DESCRIPTOR_CLASS_PROPERTY)
    private String clazz;

    @Column(name = COMPONENT_DESCRIPTOR_CONFIGURATION_DESCRIPTOR_PROPERTY, codec = JsonCodec.class)
    private JsonNode configurationDescriptor;

    @Column(name = COMPONENT_DESCRIPTOR_ACTIONS_PROPERTY)
    private String actions;

    @Column(name = SEARCH_TEXT_PROPERTY)
    private String searchText;

    public ComponentDescriptorEntity() {
    }

    public ComponentDescriptorEntity(ComponentDescriptor component) {
        if (component.getId() != null) {
            this.id = component.getId().getId();
        }
        this.actions = component.getActions();
        this.type = component.getType();
        this.scope = component.getScope();
        this.name = component.getName();
        this.clazz = component.getClazz();
        this.configurationDescriptor = component.getConfigurationDescriptor();
        this.searchText = component.getName();
    }

    @Override
    public ComponentDescriptor toData() {
        ComponentDescriptor data = new ComponentDescriptor(new ComponentDescriptorId(id));
        data.setType(type);
        data.setScope(scope);
        data.setName(this.getName());
        data.setClazz(this.getClazz());
        data.setActions(this.getActions());
        data.setConfigurationDescriptor(this.getConfigurationDescriptor());
        return data;
    }

    @Override
    public UUID getId() {
        return id;
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public String getActions() {
        return actions;
    }

    public void setActions(String actions) {
        this.actions = actions;
    }

    public ComponentType getType() {
        return type;
    }

    public void setType(ComponentType type) {
        this.type = type;
    }

    public ComponentScope getScope() {
        return scope;
    }

    public void setScope(ComponentScope scope) {
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setClazz(String clazz) {
        this.clazz = clazz;
    }

    public JsonNode getConfigurationDescriptor() {
        return configurationDescriptor;
    }

    public void setConfigurationDescriptor(JsonNode configurationDescriptor) {
        this.configurationDescriptor = configurationDescriptor;
    }

    public String getSearchText() {
        return searchText;
    }

    @Override
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    @Override
    public String getSearchTextSource() {
        return getSearchText();
    }
}
