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
 * Delete all the items that pass the filter.
 * If an item becomes obsolete/no longer available, it is meaningful to **keep it in the catalog** (along with all the interaction data, which are very useful), and **only exclude the item from recommendations**. In such a case, use [ReQL filter](https://docs.recombee.com/reql.html) instead of deleting the item completely.
 */
public class DeleteMoreItems extends Request {

    /**
     * A [ReQL](https://docs.recombee.com/reql.html) expression, which return `true` for the items that shall be updated.
     */
    protected String filter;

    /**
     * Construct the request
     * @param filter A [ReQL](https://docs.recombee.com/reql.html) expression, which return `true` for the items that shall be updated.
     */
    public DeleteMoreItems (String filter) {
        this.filter = filter;
        this.timeout = 1000;
    }


    public String getFilter() {
         return this.filter;
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
        return "/more-items/";
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
        params.put("filter", this.filter);
        return params;
    }

}
