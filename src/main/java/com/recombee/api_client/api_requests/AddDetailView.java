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
 * Adds a detail view of a given item made by a given user.
 */
public class AddDetailView extends Request {

    /**
     * User who viewed the item
     */
    protected String userId;
    /**
     * Viewed item
     */
    protected String itemId;
    /**
     * UTC timestamp of the view as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    protected Date timestamp;
    /**
     * Duration of the view
     */
    protected Long duration;
    /**
     * Sets whether the given user/item should be created if not present in the database.
     */
    protected Boolean cascadeCreate;
    /**
     * If this detail view is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    protected String recommId;
    /**
     * A dictionary of additional data for the interaction.
     */
    protected Map<String, Object> additionalData;

    /**
     * Construct the request
     * @param userId User who viewed the item
     * @param itemId Viewed item
     */
    public AddDetailView (String userId,String itemId) {
        this.userId = userId;
        this.itemId = itemId;
        this.timeout = 1000;
    }

    /**
     * @param timestamp UTC timestamp of the view as ISO8601-1 pattern or UTC epoch time. The default value is the current time.
     */
    public AddDetailView setTimestamp(Date timestamp) {
         this.timestamp = timestamp;
         return this;
    }

    /**
     * @param duration Duration of the view
     */
    public AddDetailView setDuration(long duration) {
         this.duration = duration;
         return this;
    }

    /**
     * @param cascadeCreate Sets whether the given user/item should be created if not present in the database.
     */
    public AddDetailView setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param recommId If this detail view is based on a recommendation request, `recommId` is the id of the clicked recommendation.
     */
    public AddDetailView setRecommId(String recommId) {
         this.recommId = recommId;
         return this;
    }

    /**
     * @param additionalData A dictionary of additional data for the interaction.
     */
    public AddDetailView setAdditionalData(Map<String, Object> additionalData) {
         this.additionalData = additionalData;
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

    public long getDuration() {
         return this.duration;
    }

    public boolean getCascadeCreate() {
         if (this.cascadeCreate==null) return false;
         return this.cascadeCreate;
    }

    public String getRecommId() {
         return this.recommId;
    }

    public Map<String, Object> getAdditionalData() {
         return this.additionalData;
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
        return "/detailviews/";
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
        if (this.timestamp!=null) {
            params.put("timestamp", this.timestamp.getTime()/1000.0);
        }
        if (this.duration!=null) {
            params.put("duration", this.duration);
        }
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        if (this.recommId!=null) {
            params.put("recommId", this.recommId);
        }
        if (this.additionalData!=null) {
            params.put("additionalData", this.additionalData);
        }
        return params;
    }

}
