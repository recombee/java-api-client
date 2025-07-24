package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Scenario extends RecombeeBinding {
    /**
     * ID of the Scenario
     */
    protected String id;
    /**
     * Scenario endpoint defined in the Admin UI
     */
    protected String endpoint;

    public Scenario () {}

    public Scenario (String id,String endpoint) {
        this.id = id;
        this.endpoint = endpoint;
    }

    public Scenario (Map<String, Object> jsonObject) {
        this.id = (String) jsonObject.get("id");
        this.endpoint = (String) jsonObject.get("endpoint");
    }

    public String getId() {
         return this.id;
    }

    public String getEndpoint() {
         return this.endpoint;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.id).
        append(this.endpoint).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Scenario))
             return false;
         if (obj == this)
             return true;
    
         Scenario rhs = (Scenario) obj;
         return new EqualsBuilder().
            append(this.id, rhs.id).
            append(this.endpoint, rhs.endpoint).
            isEquals();
    }
}
