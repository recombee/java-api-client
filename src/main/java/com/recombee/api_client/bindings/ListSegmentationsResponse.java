package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class ListSegmentationsResponse extends RecombeeBinding {
    /**
     * Array of existing Segmentations
     */
    protected Segmentation[] segmentations;

    public ListSegmentationsResponse () {}

    public ListSegmentationsResponse (Segmentation[] segmentations) {
        this.segmentations = segmentations;
    }

    public ListSegmentationsResponse (Map<String, Object> jsonObject) {
        this.segmentations = (Segmentation[]) jsonObject.get("segmentations");
    }

    public Segmentation[] getSegmentations() {
         return this.segmentations;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.segmentations).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof ListSegmentationsResponse))
             return false;
         if (obj == this)
             return true;
    
         ListSegmentationsResponse rhs = (ListSegmentationsResponse) obj;
         return new EqualsBuilder().
            append(this.segmentations, rhs.segmentations).
            isEquals();
    }
}
