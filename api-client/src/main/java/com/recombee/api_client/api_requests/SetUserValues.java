package com.recombee.api_client.api_requests;

import java.util.Map;

import java.util.HashMap;

import com.recombee.api_client.util.HTTPMethod;

/**
 * Set/update (some) property values of a given user. The properties (columns) must be previously created by [Add user property](https://docs.recombee.com/api.html#add-user-property).
 */
public class SetUserValues extends SetValues {

    /**
     * ID of the user which will be modified.
     */
    protected String userId;

    /**
     * The values for the individual properties.
     * Key in the Map is the name of the property and value is the value to be set
     * Special key "!cascadeCreate" may be used. It indicates that the user of the given userId should be created if it does not exist in the database, as if the corresponding PUT method was used. Note the exclamation mark (!) at the beginning of the parameter's name to distinguish it from user property names.
     */
    protected Map<String, Object> values;

    /**
     * Construct the request
     * @param userId ID of the user which will be modified.
     * @param values The values for the individual properties. Key in the Map is the name of the property and value is the value to be set.
     */
    public SetUserValues (String userId, Map<String, Object> values) {
        super(values);
        this.userId = userId;
    }

    /**
     * @param cascadeCreate Sets whether the entity should be created if not present in the database.
     */
    @Override
    public SetUserValues setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    public String getuserId() {
         return this.userId;
    }
    
    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/users/%s", this.userId);
    }
}
