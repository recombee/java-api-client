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
 * Returns items that shall be shown to a user as next recommendations when the user e.g. scrolls the page down (*infinite scroll*) or goes to a next page.
 * It accepts `recommId` of a base recommendation request (e.g. request from the first page) and number of items that shall be returned (`count`).
 * The base request can be one of:
 *   - [Recommend items to item](https://docs.recombee.com/api.html#recommend-items-to-item)
 *   - [Recommend items to user](https://docs.recombee.com/api.html#recommend-items-to-user)
 *   - [Search items](https://docs.recombee.com/api.html#search-items)
 * All the other parameters are inherited from the base request.
 * *Recommend next items* can be called many times for a single `recommId` and each call returns different (previously not recommended) items.
 * The number of *Recommend next items* calls performed so far is returned in the `numberNextRecommsCalls` field.
 * *Recommend next items* can be requested up to 30 minutes after the base request or a previous *Recommend next items* call.
 * For billing purposes, each call to *Recommend next items* is counted as a separate recommendation request.
 */
public class RecommendNextItems extends Request {

    /**
     * ID of the base recommendation request for which next recommendations should be returned
     */
    protected String recommId;
    /**
     * Number of items to be recommended
     */
    protected Long count;

    /**
     * Construct the request
     * @param recommId ID of the base recommendation request for which next recommendations should be returned
     * @param count Number of items to be recommended
     */
    public RecommendNextItems (String recommId,long count) {
        this.recommId = recommId;
        this.count = count;
        this.timeout = 3000;
    }


    public String getRecommId() {
         return this.recommId;
    }

    public long getCount() {
         return this.count;
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
        return String.format("/recomms/next/items/%s", this.recommId);
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
        params.put("count", this.count);
        return params;
    }

}
