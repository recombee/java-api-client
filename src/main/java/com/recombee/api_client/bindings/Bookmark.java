package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Bookmark extends RecombeeBinding {
    /**
     * User who bookmarked the item
     */
    protected String userId;
    /**
     * Bookmarked item
     */
    protected String itemId;
    /**
     * UTC timestamp of the bookmark as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;

    public Bookmark () {}

    public Bookmark (String userId,String itemId,Date timestamp) {
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
    }

    public Bookmark (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        Double epoch = 1000*(Double)jsonObject.get("timestamp");
        this.timestamp = new Date(epoch.longValue());
    }

    public void setTimestamp(double epoch)
    {
         this.timestamp = new Date( (long) (1000 * epoch));
    }

    public String getUserId() {
         return this.userId;
    }

    public String getItemId() {
         return this.itemId;
    }

    public Date getTimestamp() {
         return this.timestamp;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        append(this.itemId).
        append(this.timestamp).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Bookmark))
             return false;
         if (obj == this)
             return true;
    
         Bookmark rhs = (Bookmark) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            append(this.itemId, rhs.itemId).
            append(this.timestamp, rhs.timestamp).
            isEquals();
    }
}
