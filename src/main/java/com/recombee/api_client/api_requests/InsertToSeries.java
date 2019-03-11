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
 * Inserts an existing item/series into series of given seriesId at position determined by time.
 */
public class InsertToSeries extends Request {

    /**
     * ID of the series to be inserted into.
     */
    protected String seriesId;
    /**
     * `item` iff the regular item from the catalog is to be inserted, `series` iff series is inserted as the item.
     */
    protected String itemType;
    /**
     * ID of the item iff `itemType` is `item`. ID of the series iff `itemType` is `series`.
     */
    protected String itemId;
    /**
     * Time index used for sorting items in the series. According to time, items are sorted within series in ascending order. In the example of TV show episodes, the episode number is a natural choice to be passed as time.
     */
    protected Double time;
    /**
     * Indicates that any non-existing entity specified within the request should be created (as is corresponding PUT requests were invoked). This concerns both the `seriesId` and the `itemId`. If `cascadeCreate` is set true, the behavior also depends on the `itemType`. Either item or series may be created if not present in the database.
     */
    protected Boolean cascadeCreate;

    /**
     * Construct the request
     * @param seriesId ID of the series to be inserted into.
     * @param itemType `item` iff the regular item from the catalog is to be inserted, `series` iff series is inserted as the item.
     * @param itemId ID of the item iff `itemType` is `item`. ID of the series iff `itemType` is `series`.
     * @param time Time index used for sorting items in the series. According to time, items are sorted within series in ascending order. In the example of TV show episodes, the episode number is a natural choice to be passed as time.
     */
    public InsertToSeries (String seriesId,String itemType,String itemId,double time) {
        this.seriesId = seriesId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.time = time;
        this.timeout = 1000;
    }

    /**
     * @param cascadeCreate Indicates that any non-existing entity specified within the request should be created (as is corresponding PUT requests were invoked). This concerns both the `seriesId` and the `itemId`. If `cascadeCreate` is set true, the behavior also depends on the `itemType`. Either item or series may be created if not present in the database.
     */
    public InsertToSeries setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    public String getSeriesId() {
         return this.seriesId;
    }

    public String getItemType() {
         return this.itemType;
    }

    public String getItemId() {
         return this.itemId;
    }

    public double getTime() {
         return this.time;
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
        return String.format("/series/%s/items/", this.seriesId);
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
        params.put("time", this.time);
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        return params;
    }

}
