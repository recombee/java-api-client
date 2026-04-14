package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.bindings.Logic;
import com.recombee.api_client.bindings.CompositeRecommendationStageParameters;
import com.recombee.api_client.util.HTTPMethod;

/**
 * Returns Item segments that shall be shown to a user as next recommendations when the user e.g. scrolls the page down (*infinite scroll*) or goes to the next page.
 * It accepts `recommId` of a base recommendation request (e.g., request from the first page) and the number of segments that shall be returned (`count`).
 * The base request can be one of:
 *   - [Recommend Item Segments to Item](https://docs.recombee.com/api#recommend-item-segments-to-item)
 *   - [Recommend Item Segments to User](https://docs.recombee.com/api#recommend-item-segments-to-user)
 *   - [Recommend Item Segments to Item Segment](https://docs.recombee.com/api#recommend-item-segments-to-item-segment)
 *   - [Search Item Segments](https://docs.recombee.com/api#search-item-segments)
 * All the other parameters are inherited from the base request.
 * *Recommend next Item segments* can be called many times for a single `recommId` and each call returns different (previously not recommended) segments.
 * The number of *Recommend next Item segments* calls performed so far is returned in the `numberNextRecommsCalls` field.
 * *Recommend next Item segments* can be requested up to 30 minutes after the base request or a previous *Recommend next Item segments* call.
 * For billing purposes, each call to *Recommend next Item segments* is counted as a separate recommendation request.
 */
public class RecommendNextItemSegments extends Request {

    /**
     * ID of the base recommendation request for which next recommendations should be returned
     */
    protected String recommId;
    /**
     * Number of item segments to be recommended
     */
    protected Long count;

    /**
     * Construct the request
     * @param recommId ID of the base recommendation request for which next recommendations should be returned
     * @param count Number of item segments to be recommended
     */
    public RecommendNextItemSegments (String recommId,long count) {
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
        return String.format("/recomms/next/item-segments/%s", this.recommId);
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
