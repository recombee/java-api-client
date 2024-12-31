package com.recombee.api_client.bindings;

import java.util.Map;

public class Recommendation extends RecombeeBinding {

    /**
    * Id of the recommended item
    */
    protected String id;
    /**
    * Property values of the recommended item (only if the recommendation requested was set to return property values)
    */
    protected Map<String, Object> values;

    public Recommendation() {}

    public Recommendation(String id)
    {
        this.id = id;
    }

    public Recommendation(String id, Map<String, Object> values)
    {
        this.id = id;
        this.values = values;
    }

    public String getId() {
         return this.id;
    }

    public Map<String, Object> getValues() {

        if(values == null)
            throw new IllegalStateException("getValues() is possible only if the recommendation requested was set to return property values (invoke setReturnProperties(true))");

        return this.values;
    }
}
