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
 * Deletes the series of the given `seriesId` from the database.
 * Deleting a series will only delete assignment of items to it, not the items themselves!
 */
public class DeleteSeries extends Request {

    /**
     * ID of the series to be deleted.
     */
    protected String seriesId;
    /**
     * If set to `true`, item with the same ID as seriesId will be also deleted. Default is `false`.
     */
    protected Boolean cascadeDelete;

    /**
     * Construct the request
     * @param seriesId ID of the series to be deleted.
     */
    public DeleteSeries (String seriesId) {
        this.seriesId = seriesId;
        this.timeout = 3000;
    }

    /**
     * @param cascadeDelete If set to `true`, item with the same ID as seriesId will be also deleted. Default is `false`.
     */
    public DeleteSeries setCascadeDelete(boolean cascadeDelete) {
         this.cascadeDelete = cascadeDelete;
         return this;
    }

    public String getSeriesId() {
         return this.seriesId;
    }

    public boolean getCascadeDelete() {
         if (this.cascadeDelete==null) return false;
         return this.cascadeDelete;
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
        return String.format("/series/%s", this.seriesId);
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
        if (this.cascadeDelete!=null) {
            params.put("cascadeDelete", this.cascadeDelete);
        }
        return params;
    }

}
