package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class DeleteMoreItemsResponse extends RecombeeBinding {
    /**
     * Number of deleted items
     */
    protected Long count;
    /**
     * IDs of deleted items
     */
    protected String[] itemIds;

    public DeleteMoreItemsResponse () {}

    public DeleteMoreItemsResponse (long count,String[] itemIds) {
        this.count = count;
        this.itemIds = itemIds;
    }

    public DeleteMoreItemsResponse (Map<String, Object> jsonObject) {
        this.count = (Long) jsonObject.get("count");
        this.itemIds = (String[]) jsonObject.get("itemIds");
    }

    public long getCount() {
         return this.count;
    }

    public String[] getItemIds() {
         return this.itemIds;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.count).
        append(this.itemIds).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof DeleteMoreItemsResponse))
             return false;
         if (obj == this)
             return true;
    
         DeleteMoreItemsResponse rhs = (DeleteMoreItemsResponse) obj;
         return new EqualsBuilder().
            append(this.count, rhs.count).
            append(this.itemIds, rhs.itemIds).
            isEquals();
    }
}
