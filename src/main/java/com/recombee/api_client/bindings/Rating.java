package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Rating extends RecombeeBinding {
    /**
     * User who submitted the rating
     */
    protected String userId;
    /**
     * Rated item
     */
    protected String itemId;
    /**
     * UTC timestamp of the rating as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Rating rescaled to interval [-1.0,1.0], where -1.0 means the worst rating possible, 0.0 means neutral, and 1.0 means absolutely positive rating. For example, in the case of 5-star evaluations, rating = (numStars-3)/2 formula may be used for the conversion.
     */
    protected Double rating;
    /**
     * If this rating is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    protected String recommId;

    public Rating () {}

    public Rating (String userId,String itemId,Date timestamp,double rating,String recommId) {
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
        this.rating = rating;
        this.recommId = recommId;
    }

    public Rating (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.rating = (Double) jsonObject.get("rating");
        this.recommId = (String) jsonObject.get("recommId");
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

    public double getRating() {
         return this.rating;
    }

    public String getRecommId() {
         return this.recommId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        append(this.itemId).
        append(this.timestamp).
        append(this.rating).
        append(this.recommId).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Rating))
             return false;
         if (obj == this)
             return true;
    
         Rating rhs = (Rating) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            append(this.itemId, rhs.itemId).
            append(this.timestamp, rhs.timestamp).
            append(this.rating, rhs.rating).
            append(this.recommId, rhs.recommId).
            isEquals();
    }
}
