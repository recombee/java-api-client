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
 * Merges interactions (purchases, ratings, bookmarks, detail views ...) of two different users under a single user ID. This is especially useful for online e-commerce applications working with anonymous users identified by unique tokens such as the session ID. In such applications, it may often happen that a user owns a persistent account, yet accesses the system anonymously while, e.g., putting items into a shopping cart. At some point in time, such as when the user wishes to confirm the purchase, (s)he logs into the system using his/her username and password. The interactions made under anonymous session ID then become connected with the persistent account, and merging these two together becomes desirable.
 * Merging happens between two users referred to as the *target* and the *source*. After the merge, all the interactions of the source user are attributed to the target user, and the source user is **deleted**.
 */
public class MergeUsers extends Request {

    /**
     * ID of the targer user.
     */
    protected String targetUserId;
    /**
     * ID of the source user.
     */
    protected String sourceUserId;
    /**
     * Sets whether the user *targetUserId* should be created if not present in the database.
     */
    protected Boolean cascadeCreate;

    /**
     * Construct the request
     * @param targetUserId ID of the targer user.
     * @param sourceUserId ID of the source user.
     */
    public MergeUsers (String targetUserId,String sourceUserId) {
        this.targetUserId = targetUserId;
        this.sourceUserId = sourceUserId;
        this.timeout = 10000;
    }

    /**
     * @param cascadeCreate Sets whether the user *targetUserId* should be created if not present in the database.
     */
    public MergeUsers setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    public String getTargetUserId() {
         return this.targetUserId;
    }

    public String getSourceUserId() {
         return this.sourceUserId;
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
        return HTTPMethod.PUT;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/users/%s/merge/%s", this.targetUserId,this.sourceUserId);
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate.toString());
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
