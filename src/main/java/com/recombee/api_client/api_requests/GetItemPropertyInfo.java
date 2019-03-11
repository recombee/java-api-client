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
 * Gets information about specified item property.
 */
public class GetItemPropertyInfo extends Request {

    /**
     * Name of the property about which the information is to be retrieved.
     */
    protected String propertyName;

    /**
     * Construct the request
     * @param propertyName Name of the property about which the information is to be retrieved.
     */
    public GetItemPropertyInfo (String propertyName) {
        this.propertyName = propertyName;
        this.timeout = 1000;
    }


    public String getPropertyName() {
         return this.propertyName;
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
        return String.format("/items/properties/%s", this.propertyName);
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
        return params;
    }

}
