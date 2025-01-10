package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class Segmentation extends RecombeeBinding {
    /**
     * Id of the Segmentation
     */
    protected String segmentationId;
    /**
     * Determines on which type of data (e.g. `items`) the Segmentation is based
     */
    protected String sourceType;
    /**
     * Determines the type of the segmentation (Property-based, Manual ReQL, Auto ReQL)
     */
    protected String segmentationType;
    /**
     * Title of the Segmentation
     */
    protected String title;
    /**
     * Description of the Segmentation
     */
    protected String description;

    public Segmentation () {}

    public Segmentation (String segmentationId,String sourceType,String segmentationType) {
        this.segmentationId = segmentationId;
        this.sourceType = sourceType;
        this.segmentationType = segmentationType;
    }

    public Segmentation (String segmentationId,String sourceType,String segmentationType,String title,String description) {
        this.segmentationId = segmentationId;
        this.sourceType = sourceType;
        this.segmentationType = segmentationType;
        this.title = title;
        this.description = description;
    }

    public Segmentation (Map<String, Object> jsonObject) {
        this.segmentationId = (String) jsonObject.get("segmentationId");
        this.sourceType = (String) jsonObject.get("sourceType");
        this.segmentationType = (String) jsonObject.get("segmentationType");
        this.title = (String) jsonObject.get("title");
        this.description = (String) jsonObject.get("description");
    }

    public String getSegmentationId() {
         return this.segmentationId;
    }

    public String getSourceType() {
         return this.sourceType;
    }

    public String getSegmentationType() {
         return this.segmentationType;
    }

    public String getTitle() {
         return this.title;
    }

    public String getDescription() {
         return this.description;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.segmentationId).
        append(this.sourceType).
        append(this.segmentationType).
        append(this.title).
        append(this.description).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof Segmentation))
             return false;
         if (obj == this)
             return true;
    
         Segmentation rhs = (Segmentation) obj;
         return new EqualsBuilder().
            append(this.segmentationId, rhs.segmentationId).
            append(this.sourceType, rhs.sourceType).
            append(this.segmentationType, rhs.segmentationType).
            append(this.title, rhs.title).
            append(this.description, rhs.description).
            isEquals();
    }
}
