package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class SeriesItem extends RecombeeBinding {
    /**
     * `item` iff the regular item from the catalog is to be inserted, `series` iff series is inserted as the item.
     */
    protected String itemType;
    /**
     * ID of the item iff `itemType` is `item`. ID of the series iff `itemType` is `series`.
     */
    protected String itemId;
    /**
     * Time index used for sorting items in the series. According to time, items are sorted within series in ascending order. In the example of TV show episodes, the episode number is a natural choice to be passed as time.
     */
    protected Double time;

    public SeriesItem () {}

    public SeriesItem (String itemType,String itemId,double time) {
        this.itemType = itemType;
        this.itemId = itemId;
        this.time = time;
    }

    public SeriesItem (Map<String, Object> jsonObject) {
        this.itemType = (String) jsonObject.get("itemType");
        this.itemId = (String) jsonObject.get("itemId");
        this.time = (Double) jsonObject.get("time");
    }

    public String getItemType() {
         return this.itemType;
    }

    public String getItemId() {
         return this.itemId;
    }

    public double getTime() {
         return this.time;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.itemType).
        append(this.itemId).
        append(this.time).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof SeriesItem))
             return false;
         if (obj == this)
             return true;
    
         SeriesItem rhs = (SeriesItem) obj;
         return new EqualsBuilder().
            append(this.itemType, rhs.itemType).
            append(this.itemId, rhs.itemId).
            append(this.time, rhs.time).
            isEquals();
    }
}
