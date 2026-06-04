package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class PropertyInfo extends RecombeeBinding {
    /**
     * Name of the property
     */
    protected String name;
    /**
     * Type of the property
     */
    protected String type;
    /**
     * [Role](https://docs.recombee.com/api/property_roles_metadata#roles) assigned to the property.
     * Role defines how the property is interpreted by the system.
     */
    protected PropertyRole role;
    /**
     * [Metadata](https://docs.recombee.com/api/property_roles_metadata#metadata) entries associated with the property.
     * Metadata provides additional configuration or annotations that influence how the property is processed.
     */
    protected PropertyMetadata[] metadata;

    public PropertyInfo () {}

    public PropertyInfo (String name,String type) {
        this.name = name;
        this.type = type;
    }

    public PropertyInfo (String name,String type,PropertyRole role,PropertyMetadata[] metadata) {
        this.name = name;
        this.type = type;
        this.role = role;
        this.metadata = metadata;
    }

    public PropertyInfo (Map<String, Object> jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.type = (String) jsonObject.get("type");
        this.role = (PropertyRole) jsonObject.get("role");
        this.metadata = (PropertyMetadata[]) jsonObject.get("metadata");
    }

    public String getName() {
         return this.name;
    }

    public String getType() {
         return this.type;
    }

    public PropertyRole getRole() {
         return this.role;
    }

    public PropertyMetadata[] getMetadata() {
         return this.metadata;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.name).
        append(this.type).
        append(this.role).
        append(this.metadata).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof PropertyInfo))
             return false;
         if (obj == this)
             return true;
    
         PropertyInfo rhs = (PropertyInfo) obj;
         return new EqualsBuilder().
            append(this.name, rhs.name).
            append(this.type, rhs.type).
            append(this.role, rhs.role).
            append(this.metadata, rhs.metadata).
            isEquals();
    }
}
