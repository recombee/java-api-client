package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class ListSearchSynonymsResponse extends RecombeeBinding {
    /**
     * Defined search synonyms.
     */
    protected SearchSynonym[] synonyms;

    public ListSearchSynonymsResponse () {}

    public ListSearchSynonymsResponse (SearchSynonym[] synonyms) {
        this.synonyms = synonyms;
    }

    public ListSearchSynonymsResponse (Map<String, Object> jsonObject) {
        this.synonyms = (SearchSynonym[]) jsonObject.get("synonyms");
    }

    public SearchSynonym[] getSynonyms() {
         return this.synonyms;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.synonyms).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof ListSearchSynonymsResponse))
             return false;
         if (obj == this)
             return true;
    
         ListSearchSynonymsResponse rhs = (ListSearchSynonymsResponse) obj;
         return new EqualsBuilder().
            append(this.synonyms, rhs.synonyms).
            isEquals();
    }
}
