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
 * Gets a list of IDs of users currently present in the catalog.
 */
public class ListUsers extends Request {

    /**
     * Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression, which allows you to filter users to be listed. Only the users for which the expression is *true* will be returned.
     */
    protected String filter;
    /**
     * The number of users to be listed.
     */
    protected Long count;
    /**
     * Specifies the number of users to skip (ordered by `userId`).
     */
    protected Long offset;
    /**
     * With `returnProperties=true`, property values of the listed users are returned along with their IDs in a JSON dictionary. 
     * Example response:
     * ```
     *   [
     *     {
     *       "userId": "user-81",
     *       "country": "US",
     *       "sex": "M"
     *     },
     *     {
     *       "userId": "user-314",
     *       "country": "CAN",
     *       "sex": "F"
     *     }
     *   ]
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   [
     *     {
     *       "userId": "user-81",
     *       "country": "US"
     *     },
     *     {
     *       "userId": "user-314",
     *       "country": "CAN"
     *     }
     *   ]
     * ```
     */
    protected String[] includedProperties;

    /**
     * Construct the request
     */
    public ListUsers () {
        this.timeout = 100000;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression, which allows you to filter users to be listed. Only the users for which the expression is *true* will be returned.
     */
    public ListUsers setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param count The number of users to be listed.
     */
    public ListUsers setCount(long count) {
         this.count = count;
         return this;
    }

    /**
     * @param offset Specifies the number of users to skip (ordered by `userId`).
     */
    public ListUsers setOffset(long offset) {
         this.offset = offset;
         return this;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the listed users are returned along with their IDs in a JSON dictionary. 
     * Example response:
     * ```
     *   [
     *     {
     *       "userId": "user-81",
     *       "country": "US",
     *       "sex": "M"
     *     },
     *     {
     *       "userId": "user-314",
     *       "country": "CAN",
     *       "sex": "F"
     *     }
     *   ]
     * ```
     */
    public ListUsers setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   [
     *     {
     *       "userId": "user-81",
     *       "country": "US"
     *     },
     *     {
     *       "userId": "user-314",
     *       "country": "CAN"
     *     }
     *   ]
     * ```
     */
    public ListUsers setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    public String getFilter() {
         return this.filter;
    }

    public long getCount() {
         return this.count;
    }

    public long getOffset() {
         return this.offset;
    }

    public boolean getReturnProperties() {
         if (this.returnProperties==null) return false;
         return this.returnProperties;
    }

    public String[] getIncludedProperties() {
         return this.includedProperties;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.GET;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return "/users/list/";
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        if (this.filter!=null) {
            params.put("filter", this.filter.toString());
        }
        if (this.count!=null) {
            params.put("count", this.count.toString());
        }
        if (this.offset!=null) {
            params.put("offset", this.offset.toString());
        }
        if (this.returnProperties!=null) {
            params.put("returnProperties", this.returnProperties.toString());
        }
        if (this.includedProperties!=null) {
            String includedPropertiesStr = "";
            for(String el: this.includedProperties) includedPropertiesStr += ((includedPropertiesStr.equals(""))?"":",") + el;
            params.put("includedProperties", includedPropertiesStr);
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
