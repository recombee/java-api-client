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
 * Deletes synonym of given `id` and this synonym is no longer taken into account in the [Search items](https://docs.recombee.com/api.html#search-items).
 */
public class DeleteSearchSynonym extends Request {

    /**
     * ID of the synonym that should be deleted.
     */
    protected String id;

    /**
     * Construct the request
     * @param id ID of the synonym that should be deleted.
     */
    public DeleteSearchSynonym (String id) {
        this.id = id;
        this.timeout = 10000;
    }


    public String getId() {
         return this.id;
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
        return String.format("/synonyms/items/%s", this.id);
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
