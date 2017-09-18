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
     * Id of session in which the user viewed the item
     */
    protected String sessionId;
    /**
     * UTC timestamp of the rating as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Viewed portion of the item (number between 0.0 (viewed nothing) and 1.0 (viewed full item) ).
     */
    protected Double portion;

    public ViewPortion () {}

    public ViewPortion (String userId,String itemId,String sessionId,Date timestamp,double portion) {
        this.userId = userId;
        this.itemId = itemId;
        this.sessionId = sessionId;
        this.timestamp = timestamp;
        this.portion = portion;
    }

    public ViewPortion (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.sessionId = (String) jsonObject.get("sessionId");
        this.portion = (Double) jsonObject.get("portion");
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

    public String getSessionId() {
         return this.sessionId;
    }

    public Date getTimestamp() {
         return this.timestamp;
    }

    public double getPortion() {
         return this.portion;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        append(this.itemId).
        append(this.sessionId).
        append(this.timestamp).
        append(this.portion).
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
            append(this.sessionId, rhs.sessionId).
            append(this.timestamp, rhs.timestamp).
            append(this.portion, rhs.portion).
            isEquals();
    }
}
