package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class GroupItem extends RecombeeBinding {
    /**
     * `item` iff the regular item from the catalog is to be inserted, `group` iff group is inserted as the item.
     */
    protected String itemType;
    /**
     * ID of the item iff `itemType` is `item`. ID of the group iff `itemType` is `group`.
     */
    protected String itemId;

    public GroupItem () {}

    public GroupItem (String itemType,String itemId) {
        this.itemType = itemType;
        this.itemId = itemId;
    }

    public GroupItem (Map<String, Object> jsonObject) {
        this.itemType = (String) jsonObject.get("itemType");
        this.itemId = (String) jsonObject.get("itemId");
    }

    public String getItemType() {
         return this.itemType;
    }

    public String getItemId() {
         return this.itemId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.itemType).
        append(this.itemId).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof GroupItem))
             return false;
         if (obj == this)
             return true;
    
         GroupItem rhs = (GroupItem) obj;
         return new EqualsBuilder().
            append(this.itemType, rhs.itemType).
            append(this.itemId, rhs.itemId).
            isEquals();
    }
}
