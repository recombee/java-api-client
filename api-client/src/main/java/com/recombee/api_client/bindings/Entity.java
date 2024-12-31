package com.recombee.api_client.bindings;

import java.util.Map;

public abstract class Entity extends RecombeeBinding {

    /**
     * Property values of the entity (only if the list requested was set to return property values)
     */
    protected Map<String, Object> values;
    private boolean valuesAreSet;

    public Entity() {}

    public Entity(Map<String, Object> values)
    {
        this.values = values;
        this.valuesAreSet = true;
    }

    public Map<String, Object> getValues() {

        if(!this.valuesAreSet)
            throw new IllegalStateException("getValues() is possible only if the recommendation requested was set to return property values (invoke setReturnProperties(true))");

        return this.values;
    }
}
