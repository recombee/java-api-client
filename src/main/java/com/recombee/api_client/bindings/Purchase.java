package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Purchase extends RecombeeBinding {
    /**
     * User who purchased the item
     */
    protected String userId;
    /**
     * Purchased item
     */
    protected String itemId;
    /**
     * UTC timestamp of the purchase as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Amount (number) of purchased items. The default is 1. For example if `user-x` purchases two `item-y` during a single order (session...), the `amount` should equal to 2.
     */
    protected Double amount;
    /**
     * Price paid by the user for the item. If `amount` is greater than 1, sum of prices of all the items should be given.
     */
    protected Double price;
    /**
     * Your profit from the purchased item. The profit is natural in e-commerce domain (for example if `user-x` purchases `item-y` for $100 and the gross margin is 30 %, then the profit is $30), but is applicable also in other domains (for example at a news company it may be income from displayed advertisement on article page). If `amount` is greater than 1, sum of profit of all the items should be given.
     */
    protected Double profit;
    /**
     * If this purchase is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    protected String recommId;
    /**
     * A dictionary of additional data for the interaction.
     */
    protected Map<String, Object> additionalData;

    public Purchase () {}

    public Purchase (String userId,String itemId) {
        this.userId = userId;
        this.itemId = itemId;
    }

    public Purchase (String userId,String itemId,Date timestamp,double amount,double price,double profit,String recommId,Map<String, Object> additionalData) {
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.price = price;
        this.profit = profit;
        this.recommId = recommId;
        this.additionalData = additionalData;
    }

    public Purchase (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.amount = (Double) jsonObject.get("amount");
        this.price = (Double) jsonObject.get("price");
        this.profit = (Double) jsonObject.get("profit");
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

    public double getAmount() {
         return this.amount;
    }

    public double getPrice() {
         return this.price;
    }

    public double getProfit() {
         return this.profit;
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
        append(this.amount).
        append(this.price).
        append(this.profit).
        append(this.recommId).
        append(this.additionalData).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Purchase))
             return false;
         if (obj == this)
             return true;
    
         Purchase rhs = (Purchase) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            append(this.itemId, rhs.itemId).
            append(this.timestamp, rhs.timestamp).
            append(this.amount, rhs.amount).
            append(this.price, rhs.price).
            append(this.profit, rhs.profit).
            append(this.recommId, rhs.recommId).
            append(this.additionalData, rhs.additionalData).
            isEquals();
    }
}
