package com.recombee.api_client.bindings;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;

public class Item extends Entity {
    /**
     * Id of the item
     */
    protected String itemId;

    public Item () {}

    public Item(String itemId) {
        this.itemId = itemId;
    }

    public Item (String itemId,Map<String, Object> values) {
        super(values);
        this.itemId = itemId;
    }

    public String getItemId() {
         return this.itemId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(super.hashCode()).
        append(this.itemId).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Item))
             return false;
         if (obj == this)
             return true;
    
         Item rhs = (Item) obj;
         return new EqualsBuilder().
            append(this.itemId, rhs.itemId).
            append(this.values, rhs.values).
            isEquals();
    }
}
