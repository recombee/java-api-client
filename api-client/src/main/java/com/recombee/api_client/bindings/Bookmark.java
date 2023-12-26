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
    /**
     * If this bookmark is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    protected String recommId;
    /**
     * A dictionary of additional data for the interaction.
     */
    protected Map<String, Object> additionalData;

    public Bookmark () {}

    public Bookmark (String userId,String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    public Bookmark (String userId,String itemId,Date timestamp,String recommId,Map<String, Object> additionalData) {
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
        this.recommId = recommId;
        this.additionalData = additionalData;
    }

    public Bookmark (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.recommId = (String) jsonObject.get("recommId");
        this.additionalData = (Map<String, Object>) jsonObject.get("additionalData");
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

    public String getRecommId() {
         return this.recommId;
    }

    public Map<String, Object> getAdditionalData() {
         return this.additionalData;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        append(this.itemId).
        append(this.timestamp).
        append(this.recommId).
        append(this.additionalData).
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
            append(this.recommId, rhs.recommId).
            append(this.additionalData, rhs.additionalData).
            isEquals();
    }
}
