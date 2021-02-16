package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import java.util.Map;
import java.util.Date;

public class SearchSynonym extends RecombeeBinding {
    /**
     * Id of the synonym record
     */
    protected String id;
    /**
     * A word to which the `synonym` is specified.
     */
    protected String term;
    /**
     * A word that should considered equal to `term` by the full-text search engine.
     */
    protected String synonym;
    /**
     * If set to `true`, only `term` -> `synonym` is considered. I set to `false`, also `synonym` -> `term` works.
     */
    protected Boolean oneWay;

    public SearchSynonym () {}

    public SearchSynonym (String id,String term,String synonym,boolean oneWay) {
        this.id = id;
        this.term = term;
        this.synonym = synonym;
        this.oneWay = oneWay;
    }

    public SearchSynonym (Map<String, Object> jsonObject) {
        this.id = (String) jsonObject.get("id");
        this.term = (String) jsonObject.get("term");
        this.synonym = (String) jsonObject.get("synonym");
        this.oneWay = (Boolean) jsonObject.get("oneWay");
    }

    public String getId() {
         return this.id;
    }

    public String getTerm() {
         return this.term;
    }

    public String getSynonym() {
         return this.synonym;
    }

    public boolean getOneWay() {
         if (this.oneWay==null) return false;
         return this.oneWay;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.id).
        append(this.term).
        append(this.synonym).
        append(this.oneWay).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof SearchSynonym))
             return false;
         if (obj == this)
             return true;
    
         SearchSynonym rhs = (SearchSynonym) obj;
         return new EqualsBuilder().
            append(this.id, rhs.id).
            append(this.term, rhs.term).
            append(this.synonym, rhs.synonym).
            append(this.oneWay, rhs.oneWay).
            isEquals();
    }
}
