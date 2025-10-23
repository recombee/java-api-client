package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class DetailView extends RecombeeBinding {
    /**
     * User who viewed the item
     */
    protected String userId;
    /**
     * Viewed item
     */
    protected String itemId;
    /**
     * UTC timestamp of the view as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Duration of the view
     */
    protected Long duration;
    /**
     * If this detail view is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    protected String recommId;
    /**
     * A dictionary of additional data for the interaction.
     */
    protected Map<String, Object> additionalData;
    /**
     * Indicates whether the item was automatically presented to the user (e.g., in a swiping feed) or explicitly requested by the user (e.g., by clicking on a link). Defaults to `false`.
     */
    protected Boolean autoPresented;

    public DetailView () {}

    public DetailView (String userId,String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    public DetailView (String userId,String itemId,Date timestamp,long duration,String recommId,Map<String, Object> additionalData,boolean autoPresented) {
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
        this.duration = duration;
        this.recommId = recommId;
        this.additionalData = additionalData;
        this.autoPresented = autoPresented;
    }

    public DetailView (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.duration = (Long) jsonObject.get("duration");
        this.recommId = (String) jsonObject.get("recommId");
        this.additionalData = (Map<String, Object>) jsonObject.get("additionalData");
        this.autoPresented = (Boolean) jsonObject.get("autoPresented");
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

    public long getDuration() {
         return this.duration;
    }

    public String getRecommId() {
         return this.recommId;
    }

    public Map<String, Object> getAdditionalData() {
         return this.additionalData;
    }

    public boolean getAutoPresented() {
         if (this.autoPresented==null) return false;
         return this.autoPresented;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        append(this.itemId).
        append(this.timestamp).
        append(this.duration).
        append(this.recommId).
        append(this.additionalData).
        append(this.autoPresented).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof DetailView))
             return false;
         if (obj == this)
             return true;
    
         DetailView rhs = (DetailView) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            append(this.itemId, rhs.itemId).
            append(this.timestamp, rhs.timestamp).
            append(this.duration, rhs.duration).
            append(this.recommId, rhs.recommId).
            append(this.additionalData, rhs.additionalData).
            append(this.autoPresented, rhs.autoPresented).
            isEquals();
    }
}
