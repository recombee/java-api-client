package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.bindings.Logic;
import com.recombee.api_client.util.HTTPMethod;

/**
 * Adds a new synonym for the [Search items](https://docs.recombee.com/api.html#search-items).
 * When the `term` is used in the search query, the `synonym` is also used for the full-text search.
 * Unless `oneWay=true`, it works also in the opposite way (`synonym` -> `term`).
 * An example of a synonym can be `science fiction` for the term `sci-fi`.
 */
public class AddSearchSynonym extends Request {

    /**
     * A word to which the `synonym` is specified.
     */
    protected String term;
    /**
     * A word that should be considered equal to the `term` by the full-text search engine.
     */
    protected String synonym;
    /**
     * If set to `true`, only `term` -> `synonym` is considered. If set to `false`, also `synonym` -> `term` works.
     * Default: `false`.
     */
    protected Boolean oneWay;

    /**
     * Construct the request
     * @param term A word to which the `synonym` is specified.
     * @param synonym A word that should be considered equal to the `term` by the full-text search engine.
     */
    public AddSearchSynonym (String term,String synonym) {
        this.term = term;
        this.synonym = synonym;
        this.timeout = 10000;
    }

    /**
     * @param oneWay If set to `true`, only `term` -> `synonym` is considered. If set to `false`, also `synonym` -> `term` works.
     * Default: `false`.
     */
    public AddSearchSynonym setOneWay(boolean oneWay) {
         this.oneWay = oneWay;
         return this;
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

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.POST;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return "/synonyms/items/";
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        return params;
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("term", this.term);
        params.put("synonym", this.synonym);
        if (this.oneWay!=null) {
            params.put("oneWay", this.oneWay);
        }
        return params;
    }

}
