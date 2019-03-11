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
 * Deletes the group of given `groupId` from the database.
 * Deleting a group will only delete assignment of items to it, not the items themselves!
 */
public class DeleteGroup extends Request {

    /**
     * ID of the group to be deleted.
     */
    protected String groupId;

    /**
     * Construct the request
     * @param groupId ID of the group to be deleted.
     */
    public DeleteGroup (String groupId) {
        this.groupId = groupId;
        this.timeout = 1000;
    }


    public String getGroupId() {
         return this.groupId;
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
        return String.format("/groups/%s", this.groupId);
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
