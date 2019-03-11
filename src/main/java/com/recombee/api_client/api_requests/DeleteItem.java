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
 * Deletes an item of given `itemId` from the catalog.
 * If there are any *purchases*, *ratings*, *bookmarks*, *cart additions* or *detail views* of the item present in the database, they will be deleted in cascade as well. Also, if the item is present in some *series*, it will be removed from all the *series* where present.
 * If an item becomes obsolete/no longer available, it is often meaningful to keep it in the catalog (along with all the interaction data, which are very useful), and only exclude the item from recommendations. In such a case, use [ReQL filter](https://docs.recombee.com/reql.html) instead of deleting the item completely.
 */
public class DeleteItem extends Request {

    /**
     * ID of the item to be deleted.
     */
    protected String itemId;

    /**
     * Construct the request
     * @param itemId ID of the item to be deleted.
     */
    public DeleteItem (String itemId) {
        this.itemId = itemId;
        this.timeout = 1000;
    }


    public String getItemId() {
         return this.itemId;
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
        return String.format("/items/%s", this.itemId);
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
