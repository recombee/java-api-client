package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class User extends RecombeeBinding {
    /**
     * Id of the user
     */
    protected String userId;

    public User () {}

    public User (String userId) {
        this.userId = userId;
    }

    public User (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
    }

    public String getUserId() {
         return this.userId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof User))
             return false;
         if (obj == this)
             return true;
    
         User rhs = (User) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            isEquals();
    }
}
