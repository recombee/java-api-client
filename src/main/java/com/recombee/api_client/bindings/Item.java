package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Item extends RecombeeBinding {
    /**
     * Id of the item
     */
    protected String itemId;

    public Item () {}

    public Item (String itemId) {
        this.itemId = itemId;
    }

    public Item (Map<String, Object> jsonObject) {
        this.itemId = (String) jsonObject.get("itemId");
    }

    public String getItemId() {
         return this.itemId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
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
            isEquals();
    }
}
