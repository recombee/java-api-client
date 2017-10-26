package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.util.HTTPMethod;

/**
 * The view portions feature is currently experimental.
 * Sets viewed portion of an item (for example a video or article) by a user (at a session).
 * If you send new request with the same (`userId`, `itemId`, `sessionId`), the portion gets updated.
 */
public class SetViewPortion extends Request {

    /**
     * User who viewed a portion of the item
     */
    protected String userId;
    /**
     * Viewed item
     */
    protected String itemId;
    /**
     * Viewed portion of the item (number between 0.0 (viewed nothing) and 1.0 (viewed full item) ).
     */
    protected Double portion;
    /**
     * Id of session in which the user viewed the item
     */
    protected String sessionId;
    /**
     * UTC timestamp of the rating as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Sets whether the given user/item should be created if not present in the database.
     */
    protected Boolean cascadeCreate;

    /**
     * Construct the request
     * @param userId User who viewed a portion of the item
     * @param itemId Viewed item
     * @param portion Viewed portion of the item (number between 0.0 (viewed nothing) and 1.0 (viewed full item) ).
     */
    public SetViewPortion (String userId,String itemId,double portion) {
        this.userId = userId;
        this.itemId = itemId;
        this.portion = portion;
        this.timeout = 1000;
    }

    /**
     * @param sessionId Id of session in which the user viewed the item
     */
    public SetViewPortion setSessionId(String sessionId) {
         this.sessionId = sessionId;
         return this;
    }

    /**
     * @param timestamp UTC timestamp of the rating as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    public SetViewPortion setTimestamp(Date timestamp) {
         this.timestamp = timestamp;
         return this;
    }

    /**
     * @param cascadeCreate Sets whether the given user/item should be created if not present in the database.
     */
    public SetViewPortion setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    public String getUserId() {
         return this.userId;
    }

    public String getItemId() {
         return this.itemId;
    }

    public double getPortion() {
         return this.portion;
    }

    public String getSessionId() {
         return this.sessionId;
    }

    public Date getTimestamp() {
         return this.timestamp;
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
        return "/viewportions/";
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
        params.put("userId", this.userId);
        params.put("itemId", this.itemId);
        params.put("portion", this.portion);
        if (this.sessionId!=null) {
            params.put("sessionId", this.sessionId);
        }
        if (this.timestamp!=null) {
            params.put("timestamp", this.timestamp.getTime()/1000.0);
        }
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        return params;
    }

}
