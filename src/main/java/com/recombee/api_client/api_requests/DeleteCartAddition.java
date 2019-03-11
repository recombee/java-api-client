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
 * Deletes an existing cart addition uniquely specified by `userId`, `itemId`, and `timestamp` or all the cart additions with given `userId` and `itemId` if `timestamp` is omitted.
 */
public class DeleteCartAddition extends Request {

    /**
     * ID of the user who made the cart addition.
     */
    protected String userId;
    /**
     * ID of the item of which was added to cart.
     */
    protected String itemId;
    /**
     * Unix timestamp of the cart addition. If the `timestamp` is omitted, then all the cart additions with given `userId` and `itemId` are deleted.
     */
    protected Date timestamp;

    /**
     * Construct the request
     * @param userId ID of the user who made the cart addition.
     * @param itemId ID of the item of which was added to cart.
     */
    public DeleteCartAddition (String userId,String itemId) {
        this.userId = userId;
        this.itemId = itemId;
        this.timeout = 1000;
    }

    /**
     * @param timestamp Unix timestamp of the cart addition. If the `timestamp` is omitted, then all the cart additions with given `userId` and `itemId` are deleted.
     */
    public DeleteCartAddition setTimestamp(Date timestamp) {
         this.timestamp = timestamp;
         return this;
    }

    public String getUserId() {
         return this.userId;
    }

    public String getItemId() {
         return this.itemId;
    }

    public Date getTimestamp() {
         return this.timestamp;
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
        return "/cartadditions/";
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("userId", this.userId.toString());
        params.put("itemId", this.itemId.toString());
        if (this.timestamp!=null) {
            params.put("timestamp", Double.toString(this.timestamp.getTime()/1000.0));
        }
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
