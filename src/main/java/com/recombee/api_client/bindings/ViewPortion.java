package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class ViewPortion extends RecombeeBinding {
    /**
     * User who viewed a portion of the item
     */
    protected String userId;
    /**
     * Viewed item
     */
    protected String itemId;
    /**
     * Viewed portion of the item (number between 0.0 (viewed nothing) and 1.0 (viewed full item) ). It should be the really viewed part of the item, no matter seeking, so for example if the user seeked immediately to half of the item and then viewed 10% of the item, the `portion` should still be `0.1`.
     */
    protected Double portion;
    /**
     * ID of session in which the user viewed the item. Default is `null` (`None`, `nil`, `NULL` etc. depending on language).
     */
    protected String sessionId;
    /**
     * UTC timestamp of the rating as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * If this view portion is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    protected String recommId;
    /**
     * A dictionary of additional data for the interaction.
     */
    protected Map<String, Object> additionalData;

    public ViewPortion () {}

    public ViewPortion (String userId,String itemId,double portion) {
        this.userId = userId;
        this.itemId = itemId;
        this.portion = portion;
    }

    public ViewPortion (String userId,String itemId,double portion,String sessionId,Date timestamp,String recommId,Map<String, Object> additionalData) {
        this.userId = userId;
        this.itemId = itemId;
        this.portion = portion;
        this.sessionId = sessionId;
        this.timestamp = timestamp;
        this.recommId = recommId;
        this.additionalData = additionalData;
    }

    public ViewPortion (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.portion = (Double) jsonObject.get("portion");
        this.sessionId = (String) jsonObject.get("sessionId");
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

    public double getPortion() {
         return this.portion;
    }

    public String getSessionId() {
         return this.sessionId;
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
        append(this.portion).
        append(this.sessionId).
        append(this.timestamp).
        append(this.recommId).
        append(this.additionalData).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof ViewPortion))
             return false;
         if (obj == this)
             return true;
    
         ViewPortion rhs = (ViewPortion) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            append(this.itemId, rhs.itemId).
            append(this.portion, rhs.portion).
            append(this.sessionId, rhs.sessionId).
            append(this.timestamp, rhs.timestamp).
            append(this.recommId, rhs.recommId).
            append(this.additionalData, rhs.additionalData).
            isEquals();
    }
}
