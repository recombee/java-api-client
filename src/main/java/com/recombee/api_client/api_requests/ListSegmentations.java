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
 * Return all existing items Segmentations.
 */
public class ListSegmentations extends Request {

    /**
     * List Segmentations based on a particular type of data. Currently only `items` are supported.
     */
    protected String sourceType;

    /**
     * Construct the request
     * @param sourceType List Segmentations based on a particular type of data. Currently only `items` are supported.
     */
    public ListSegmentations (String sourceType) {
        this.sourceType = sourceType;
        this.timeout = 10000;
    }


    public String getSourceType() {
         return this.sourceType;
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
        return "/segmentations/list/";
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("sourceType", this.sourceType.toString());
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
