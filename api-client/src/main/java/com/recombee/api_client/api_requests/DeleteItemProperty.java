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
 * Deleting an item property is roughly equivalent to removing a column from the table of items.
 */
public class DeleteItemProperty extends Request {

    /**
     * Name of the property to be deleted.
     */
    protected String propertyName;

    /**
     * Construct the request
     * @param propertyName Name of the property to be deleted.
     */
    public DeleteItemProperty (String propertyName) {
        this.propertyName = propertyName;
        this.timeout = 100000;
    }


    public String getPropertyName() {
         return this.propertyName;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.DELETE;
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
