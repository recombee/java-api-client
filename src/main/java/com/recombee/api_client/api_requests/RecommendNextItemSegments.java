package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.bindings.Logic;
import com.recombee.api_client.bindings.CompositeRecommendationStageParameters;
import com.recombee.api_client.bindings.PropertyRole;
import com.recombee.api_client.bindings.PropertyMetadata;
import com.recombee.api_client.util.HTTPMethod;

/**
 * Returns [Item Segments](https://docs.recombee.com/segmentations) to be shown as the next recommendations when a user scrolls (e.g., within a carousel or feed of Item Segments such as brands, artists, topics, or categories).
 * The request requires the `recommId` of a base recommendation request and the number of Segments to return (`count`).
 * The base request can be one of:
 *   - [Recommend Item Segments to Item](https://docs.recombee.com/api#recommend-item-segments-to-item)
 *   - [Recommend Item Segments to User](https://docs.recombee.com/api#recommend-item-segments-to-user)
 *   - [Recommend Item Segments to Item Segment](https://docs.recombee.com/api#recommend-item-segments-to-item-segment)
 *   - [Search Item Segments](https://docs.recombee.com/api#search-item-segments)
 * All other parameters are inherited from the base request associated with the provided `recommId`.
 * This endpoint can be called multiple times for a single `recommId`. Each call returns different Item Segments that have not been recommended in previous calls.
 * The number of calls made so far is returned in the `numberNextRecommsCalls` field.
 * Requests can be made up to 30 minutes after the base request or the most recent Recommend Next Item Segments call.
 * For billing purposes, each call to this endpoint is counted as a separate recommendation request.
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
