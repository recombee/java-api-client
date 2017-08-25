package com.recombee.api_client.bindings;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;

public class User extends Entity {
    /**
     * Id of the user
     */
    protected String userId;

    public User() {}

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, Map<String, Object> values) {
        super(values);
        this.userId = userId;
    }

    public String getUserId() {
        return this.userId;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 31).
                append(super.hashCode()).
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
                append(this.values, rhs.values).
                isEquals();
    }
}
