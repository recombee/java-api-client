package com.recombee.api_client.api_requests;

import java.util.Map;

import java.util.HashMap;

import com.recombee.api_client.util.HTTPMethod;

/**
 * Set/update (some) property values of a given item. The properties (columns) must be previously created by [Add item property](https://docs.recombee.com/api.html#add-item-property).
 */
public class SetItemValues extends Request {

    /**
     * ID of the item which will be modified.
     */
    protected String itemId;

    /**
     * The values for the individual properties.
     * Key in the Map is the name of the property and value is the value to be set
     * Special key "!cascadeCreate" may be used. It indicates that the item of the given itemId should be created if it does not exist in the database, as if the corresponding PUT method was used. Note the exclamation mark (!) at the beginning of the parameter's name to distinguish it from item property names.
     */
    protected Map<String, Object> values;

    /**
     * Construct the request
     * @param itemId ID of the item which will be modified.
     * @param values The values for the individual properties. Key in the Map is the name of the property and value is the value to be set
     */
    public SetItemValues (String itemId, Map<String, Object> values) {
        this.itemId = itemId;
        this.values = values;
    }


    public String getItemId() {
         return this.itemId;
    }

    public Map<String, Object> getValues() {
         return this.values;
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
        return String.format("/items/%s", this.itemId);
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        return new HashMap<String, Object>();
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {
        return this.values;
    }
}
