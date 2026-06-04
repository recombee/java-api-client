package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PropertyMetadata extends RecombeeBinding {
    /**
     * Name of the [metadata](https://docs.recombee.com/api/property_roles_metadata#metadata) assigned to the property.
     */
    protected String name;
    /**
     * Optional configuration for this metadata entry.
     */
    protected Map<String, Object> settings;

    public PropertyMetadata () {}

    public PropertyMetadata (String name) {
        this.name = name;
    }

    public PropertyMetadata (String name,Map<String, Object> settings) {
        this.name = name;
        this.settings = settings;
    }

    public PropertyMetadata (Map<String, Object> jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.settings = (Map<String, Object>) jsonObject.get("settings");
    }

    public String getName() {
         return this.name;
    }

    public Map<String, Object> getSettings() {
         return this.settings;
    }

    /**
     * @param settings Optional configuration for this metadata entry.
     */
    public PropertyMetadata setSettings(Map<String, Object> settings) {
         this.settings = settings;
         return this;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.name).
        append(this.settings).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof PropertyMetadata))
             return false;
         if (obj == this)
             return true;
    
         PropertyMetadata rhs = (PropertyMetadata) obj;
         return new EqualsBuilder().
            append(this.name, rhs.name).
            append(this.settings, rhs.settings).
            isEquals();
    }
}
