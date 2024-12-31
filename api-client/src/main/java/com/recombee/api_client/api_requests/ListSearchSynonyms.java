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
 * Gives the list of synonyms defined in the database.
 */
public class ListSearchSynonyms extends Request {

    /**
     * The number of synonyms to be listed.
     */
    protected Long count;
    /**
     * Specifies the number of synonyms to skip (ordered by `term`).
     */
    protected Long offset;

    /**
     * Construct the request
     */
    public ListSearchSynonyms () {
        this.timeout = 100000;
    }

    /**
     * @param count The number of synonyms to be listed.
     */
    public ListSearchSynonyms setCount(long count) {
         this.count = count;
         return this;
    }

    /**
     * @param offset Specifies the number of synonyms to skip (ordered by `term`).
     */
    public ListSearchSynonyms setOffset(long offset) {
         this.offset = offset;
         return this;
    }

    public long getCount() {
         return this.count;
    }

    public long getOffset() {
         return this.offset;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.GET;
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
        if (this.count!=null) {
            params.put("count", this.count.toString());
        }
        if (this.offset!=null) {
            params.put("offset", this.offset.toString());
        }
        return params;
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        return params;
    }

}
