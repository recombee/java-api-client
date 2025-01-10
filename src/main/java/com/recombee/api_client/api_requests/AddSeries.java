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
 * Creates a new series in the database.
 */
public class AddSeries extends Request {

    /**
     * ID of the series to be created.
     */
    protected String seriesId;
    /**
     * If set to `true`, the item will be created with the same ID as the series. Default is `true`.
     */
    protected Boolean cascadeCreate;

    /**
     * Construct the request
     * @param seriesId ID of the series to be created.
     */
    public AddSeries (String seriesId) {
        this.seriesId = seriesId;
        this.timeout = 3000;
    }

    /**
     * @param cascadeCreate If set to `true`, the item will be created with the same ID as the series. Default is `true`.
     */
    public AddSeries setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    public String getSeriesId() {
         return this.seriesId;
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
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        return params;
    }

}
