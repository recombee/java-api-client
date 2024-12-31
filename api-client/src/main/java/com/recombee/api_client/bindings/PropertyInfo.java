package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
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

    public PropertyInfo () {}

    public PropertyInfo (String name,String type) {
        this.name = name;
        this.type = type;
    }

    public PropertyInfo (Map<String, Object> jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.type = (String) jsonObject.get("type");
    }

    public String getName() {
         return this.name;
    }

    public String getType() {
         return this.type;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.name).
        append(this.type).
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
            isEquals();
    }
}
