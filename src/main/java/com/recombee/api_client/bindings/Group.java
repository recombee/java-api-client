package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Group extends RecombeeBinding {
    /**
     * Id of the group
     */
    protected String groupId;

    public Group () {}

    public Group (String groupId) {
        this.groupId = groupId;
    }

    public Group (Map<String, Object> jsonObject) {
        this.groupId = (String) jsonObject.get("groupId");
    }

    public String getGroupId() {
         return this.groupId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.groupId).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Group))
             return false;
         if (obj == this)
             return true;
    
         Group rhs = (Group) obj;
         return new EqualsBuilder().
            append(this.groupId, rhs.groupId).
            isEquals();
    }
}
