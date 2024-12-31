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
 * Removes an existing group item from the group.
 */
public class RemoveFromGroup extends Request {

    /**
     * ID of the group from which a group item is to be removed.
     */
    protected String groupId;
    /**
     * Type of the item to be removed.
     */
    protected String itemType;
    /**
     * ID of the item iff `itemType` is `item`. ID of the group iff `itemType` is `group`.
     */
    protected String itemId;

    /**
     * Construct the request
     * @param groupId ID of the group from which a group item is to be removed.
     * @param itemType Type of the item to be removed.
     * @param itemId ID of the item iff `itemType` is `item`. ID of the group iff `itemType` is `group`.
     */
    public RemoveFromGroup (String groupId,String itemType,String itemId) {
        this.groupId = groupId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.timeout = 1000;
    }


    public String getGroupId() {
         return this.groupId;
    }

    public String getItemType() {
         return this.itemType;
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
        return String.format("/groups/%s/items/", this.groupId);
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("itemType", this.itemType.toString());
        params.put("itemId", this.itemId.toString());
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
