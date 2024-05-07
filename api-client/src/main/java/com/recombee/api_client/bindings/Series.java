package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Series extends RecombeeBinding {
    /**
     * Id of the series
     */
    protected String seriesId;

    public Series () {}

    public Series (String seriesId) {
        this.seriesId = seriesId;
    }

    public Series (Map<String, Object> jsonObject) {
        this.seriesId = (String) jsonObject.get("seriesId");
    }

    public String getSeriesId() {
         return this.seriesId;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.seriesId).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Series))
             return false;
         if (obj == this)
             return true;
    
         Series rhs = (Series) obj;
         return new EqualsBuilder().
            append(this.seriesId, rhs.seriesId).
            isEquals();
    }
}
