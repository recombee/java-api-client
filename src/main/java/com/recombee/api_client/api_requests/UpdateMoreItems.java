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
 * Update (some) property values of all the items that pass the filter.
 * Example: *Setting all the items that are older than a week as unavailable*
 *   ```
 *     {
 *       "filter": "'releaseDate' < now() - 7*24*3600",
 *       "changes": {"available": false}
 *     }
 *   ```
 */
public class UpdateMoreItems extends Request {

    /**
     * A [ReQL](https://docs.recombee.com/reql.html) expression, which return `true` for the items that shall be updated.
     */
    protected String filter;
    /**
     * A dictionary where the keys are properties which shall be updated.
     */
    protected Map<String, Object> changes;

    /**
     * Construct the request
     * @param filter A [ReQL](https://docs.recombee.com/reql.html) expression, which return `true` for the items that shall be updated.
     * @param changes A dictionary where the keys are properties which shall be updated.
     */
    public UpdateMoreItems (String filter,Map<String, Object> changes) {
        this.filter = filter;
        this.changes = changes;
        this.timeout = 1000;
    }


    public String getFilter() {
         return this.filter;
    }

    public Map<String, Object> getChanges() {
         return this.changes;
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
        params.put("changes", this.changes);
        return params;
    }

}
