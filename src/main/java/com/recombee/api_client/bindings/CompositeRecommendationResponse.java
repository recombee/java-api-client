package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class CompositeRecommendationResponse extends RecombeeBinding {
    /**
     * Id of the composite recommendation request
     */
    protected String recommId;
    /**
     * Parameters of the source stage
     */
    protected Recommendation source;
    /**
     * Obtained recommendations
     */
    protected Recommendation[] recomms;
    /**
     * How many times *Recommend Next Items* have been called for this `recommId`
     */
    protected Long numberNextRecommsCalls;

    public CompositeRecommendationResponse () {}

    public CompositeRecommendationResponse (String recommId,Recommendation source,Recommendation[] recomms) {
        this.recommId = recommId;
        this.source = source;
        this.recomms = recomms;
    }

    public CompositeRecommendationResponse (String recommId,Recommendation source,Recommendation[] recomms,long numberNextRecommsCalls) {
        this.recommId = recommId;
        this.source = source;
        this.recomms = recomms;
        this.numberNextRecommsCalls = numberNextRecommsCalls;
    }

    public CompositeRecommendationResponse (Map<String, Object> jsonObject) {
        this.recommId = (String) jsonObject.get("recommId");
        this.source = (Recommendation) jsonObject.get("source");
        this.recomms = (Recommendation[]) jsonObject.get("recomms");
        this.numberNextRecommsCalls = (Long) jsonObject.get("numberNextRecommsCalls");
    }

    public String getRecommId() {
         return this.recommId;
    }

    public Recommendation getSource() {
         return this.source;
    }

    public Recommendation[] getRecomms() {
         return this.recomms;
    }

    public long getNumberNextRecommsCalls() {
         return this.numberNextRecommsCalls;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.recommId).
        append(this.source).
        append(this.recomms).
        append(this.numberNextRecommsCalls).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof CompositeRecommendationResponse))
             return false;
         if (obj == this)
             return true;
    
         CompositeRecommendationResponse rhs = (CompositeRecommendationResponse) obj;
         return new EqualsBuilder().
            append(this.recommId, rhs.recommId).
            append(this.source, rhs.source).
            append(this.recomms, rhs.recomms).
            append(this.numberNextRecommsCalls, rhs.numberNextRecommsCalls).
            isEquals();
    }
}
