package com.recombee.api_client.bindings;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.Iterator;

public class RecommendationResponse extends RecombeeBinding implements Iterable<Recommendation> {
    /**
     * Id of the recommendation request
     */
    protected String recommId;
    /**
     * Obtained recommendations
     */
    protected Recommendation[] recomms;
    /**
     * Number of performed RecommendNextItems calls for this recommId
     */
    protected int numberNextRecommsCalls;
    /**
     * Name of AB-testing group to which the request belongs if there is a custom AB-testing running.
     */
    protected String abGroup;

    public RecommendationResponse () {}

    public RecommendationResponse (String recommId, Recommendation[] recomms) {
        this.recommId = recommId;
        this.recomms = recomms;
        this.numberNextRecommsCalls = 0;
        this.abGroup = null;
    }

    public RecommendationResponse (String recommId, Recommendation[] recomms, int numberNextRecommsCalls) {
        this.recommId = recommId;
        this.recomms = recomms;
        this.numberNextRecommsCalls = numberNextRecommsCalls;
        this.abGroup = null;
    }

    public RecommendationResponse (String recommId, Recommendation[] recomms,
                                   String abGroup) {
        this.recommId = recommId;
        this.recomms = recomms;
        this.numberNextRecommsCalls = 0;
        this.abGroup = abGroup;
    }

    public RecommendationResponse (String recommId, Recommendation[] recomms,
                                   int numberNextRecommsCalls, String abGroup) {
        this.recommId = recommId;
        this.recomms = recomms;
        this.numberNextRecommsCalls = numberNextRecommsCalls;
        this.abGroup = abGroup;
    }

    /**
     * Get id of the recommendation request
     */
    public String getRecommId() {
         return this.recommId;
    }

    /**
     * Get obtained recommendations
     */
    public Recommendation[] getRecomms() {
         return this.recomms;
    }

    /**
     * Get number of performed RecommendNextItems calls for this recommId
     */
    public int getNumberNextRecommsCalls() {
         return this.numberNextRecommsCalls;
    }

    /**
     * Get name of AB-testing group to which the request belongs if there is a custom AB-testing running
     */
    public String getAbGroup() {
         return this.abGroup;
    }


    /**
     * Get ids of recommended entities
     */
    public String[] getIds() {
        String[] ids = new String[recomms.length];
        for(int i = 0; i< recomms.length; i++)
            ids[i] = recomms[i].getId();
        return ids;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.recommId).
        append(this.recomms).
        append(this.abGroup).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof RecommendationResponse))
             return false;
         if (obj == this)
             return true;
    
         RecommendationResponse rhs = (RecommendationResponse) obj;
         return new EqualsBuilder().
            append(this.recommId, rhs.recommId).
            append(this.recomms, rhs.recomms).
            append(this.abGroup, rhs.abGroup).
            isEquals();
    }

    @Override
    public Iterator<Recommendation> iterator() {
        return Arrays.asList(recomms).iterator();
    }
}
