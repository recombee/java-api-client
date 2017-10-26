package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class CartAddition extends RecombeeBinding {
    /**
     * User who added the item to the cart
     */
    protected String userId;
    /**
     * Item added to the cart
     */
    protected String itemId;
    /**
     * UTC timestamp of the cart addition as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Amount (number) added to cart. The default is 1. For example if `user-x` adds two `item-y` during a single order (session...), the `amount` should equal to 2.
     */
    protected Double amount;
    /**
     * Price of the added item. If `amount` is greater than 1, sum of prices of all the items should be given.
     */
    protected Double price;

    public CartAddition () {}

    public CartAddition (String userId,String itemId,Date timestamp,double amount,double price) {
        this.userId = userId;
        this.itemId = itemId;
        this.timestamp = timestamp;
        this.amount = amount;
        this.price = price;
    }

    public CartAddition (Map<String, Object> jsonObject) {
        this.userId = (String) jsonObject.get("userId");
        this.itemId = (String) jsonObject.get("itemId");
        this.amount = (Double) jsonObject.get("amount");
        this.price = (Double) jsonObject.get("price");
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

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.userId).
        append(this.itemId).
        append(this.timestamp).
        append(this.amount).
        append(this.price).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof CartAddition))
             return false;
         if (obj == this)
             return true;
    
         CartAddition rhs = (CartAddition) obj;
         return new EqualsBuilder().
            append(this.userId, rhs.userId).
            append(this.itemId, rhs.itemId).
            append(this.timestamp, rhs.timestamp).
            append(this.amount, rhs.amount).
            append(this.price, rhs.price).
            isEquals();
    }
}
