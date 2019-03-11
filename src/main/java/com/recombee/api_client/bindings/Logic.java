package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Logic extends RecombeeBinding {
    /**
     * Name of the logic that should be used
     */
    protected String name;
    /**
     * Parameters passed to the logic
     */
    protected Map<String, Object> settings;

    public Logic () {}

    public Logic (String name) {
        this.name = name;
    }

    public Logic (String name,Map<String, Object> settings) {
        this.name = name;
        this.settings = settings;
    }

    public Logic (Map<String, Object> jsonObject) {
        this.name = (String) jsonObject.get("name");
        this.settings = (Map<String, Object>) jsonObject.get("settings");
    }

    public String getName() {
         return this.name;
    }

    public Map<String, Object> getSettings() {
         return this.settings;
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
         if (!(obj instanceof Logic))
             return false;
         if (obj == this)
             return true;
    
         Logic rhs = (Logic) obj;
         return new EqualsBuilder().
            append(this.name, rhs.name).
            append(this.settings, rhs.settings).
            isEquals();
    }
}
