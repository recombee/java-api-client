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
 * Deletes an existing view portion specified by (`userId`, `itemId`, `sessionId`) from the database.
 */
public class DeleteViewPortion extends Request {

    /**
     * ID of the user who rated the item.
     */
    protected String userId;
    /**
     * ID of the item which was rated.
     */
    protected String itemId;
    /**
     * Identifier of a session.
     */
    protected String sessionId;

    /**
     * Construct the request
     * @param userId ID of the user who rated the item.
     * @param itemId ID of the item which was rated.
     */
    public DeleteViewPortion (String userId,String itemId) {
        this.userId = userId;
        this.itemId = itemId;
        this.timeout = 1000;
    }

    /**
     * @param sessionId Identifier of a session.
     */
    public DeleteViewPortion setSessionId(String sessionId) {
         this.sessionId = sessionId;
         return this;
    }

    public String getUserId() {
         return this.userId;
    }

    public String getItemId() {
         return this.itemId;
    }

    public String getSessionId() {
         return this.sessionId;
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
        return "/viewportions/";
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
        if (this.sessionId!=null) {
            params.put("sessionId", this.sessionId.toString());
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
