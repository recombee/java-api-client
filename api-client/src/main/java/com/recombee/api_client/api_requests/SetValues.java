package com.recombee.api_client.api_requests;

import java.util.Map;

import java.util.HashMap;

import com.recombee.api_client.util.HTTPMethod;

/**
 * Set/update (some) property values of an entity.
 */
public abstract class SetValues extends Request {

    /**
     * The values for the individual properties.
     * Key in the Map is the name of the property and value is the value to be set
     * Special key "!cascadeCreate" may be used. It indicates that the entity should be created if it does not exist in the database, as if the corresponding PUT method was used. Note the exclamation mark (!) at the beginning of the parameter's name to distinguish it from the property names.
     */
    protected Map<String, Object> values;

    /**
     * Sets whether the entity should be created if not present in the database.
     */
    protected Boolean cascadeCreate;

    /**
     * Construct the request
     * @param values The values for the individual properties. Key in the Map is the name of the property and value is the value to be set.
     */
    public SetValues (Map<String, Object> values) {
        this.values = values;
        this.cascadeCreate = false;
    }

    public Map<String, Object> getValues() {
         return this.values;
    }

    /**
     * @param cascadeCreate Sets whether the entity should be created if not present in the database.
     */
    public SetValues setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
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

        if(this.cascadeCreate) {
            Map<String, Object> values = new HashMap<String, Object>(this.values);
            values.put("!cascadeCreate", true);
            return values;
        }

        return this.values;
    }
}
