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
 * Removes an existing series item from the series.
 */
public class RemoveFromSeries extends Request {

    /**
     * ID of the series from which a series item is to be removed.
     */
    protected String seriesId;
    /**
     * Type of the item to be removed.
     */
    protected String itemType;
    /**
     * ID of the item iff `itemType` is `item`. ID of the series iff `itemType` is `series`.
     */
    protected String itemId;

    /**
     * Construct the request
     * @param seriesId ID of the series from which a series item is to be removed.
     * @param itemType Type of the item to be removed.
     * @param itemId ID of the item iff `itemType` is `item`. ID of the series iff `itemType` is `series`.
     */
    public RemoveFromSeries (String seriesId,String itemType,String itemId) {
        this.seriesId = seriesId;
        this.itemType = itemType;
        this.itemId = itemId;
        this.timeout = 3000;
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
        return params;
    }

}
