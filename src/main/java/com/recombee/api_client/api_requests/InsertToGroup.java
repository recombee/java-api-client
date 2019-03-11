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
 * Inserts an existing item/group into group of given `groupId`.
 */
public class InsertToGroup extends Request {

    /**
     * ID of the group to be inserted into.
     */
    protected String groupId;
    /**
     * `item` iff the regular item from the catalog is to be inserted, `group` iff group is inserted as the item.
     */
    protected String itemType;
    /**
     * ID of the item iff `itemType` is `item`. ID of the group iff `itemType` is `group`.
     */
    protected String itemId;
    /**
     * Indicates that any non-existing entity specified within the request should be created (as is corresponding PUT requests were invoked). This concerns both the `groupId` and the `groupId`. If `cascadeCreate` is set true, the behavior also depends on the `itemType`. Either items or group may be created if not present in the database.
     */
    protected Boolean cascadeCreate;

    /**
     * Construct the request
     * @param groupId ID of the group to be inserted into.
     * @param itemType `item` iff the regular item from the catalog is to be inserted, `group` iff group is inserted as the item.
     * @param itemId ID of the item iff `itemType` is `item`. ID of the group iff `itemType` is `group`.
     */
    public InsertToGroup (String groupId,String itemType,String itemId) {
        this.groupId = groupId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.timeout = 1000;
    }

    /**
     * @param cascadeCreate Indicates that any non-existing entity specified within the request should be created (as is corresponding PUT requests were invoked). This concerns both the `groupId` and the `groupId`. If `cascadeCreate` is set true, the behavior also depends on the `itemType`. Either items or group may be created if not present in the database.
     */
    public InsertToGroup setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
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

    public boolean getCascadeCreate() {
         if (this.cascadeCreate==null) return false;
         return this.cascadeCreate;
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
        return String.format("/groups/%s/items/", this.groupId);
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
        params.put("itemType", this.itemType);
        params.put("itemId", this.itemId);
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        return params;
    }

}
