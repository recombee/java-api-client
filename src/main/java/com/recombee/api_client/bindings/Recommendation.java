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

    /**
     * Evaluations of ReQL expressions specified in the request and calculated for the recommended item.
     * This is non-null only if some reqlExpressions were specified in the request.
     */
    protected Map<String, Object> reqlEvaluations;

    public Recommendation() {
    }

    public Recommendation(String id) {
        this.id = id;
    }

    public Recommendation(String id, Map<String, Object> values, Map<String, Object> reqlEvaluations) {
        this.id = id;
        this.values = values;
        this.reqlEvaluations = reqlEvaluations;
    }

    public String getId() {
        return this.id;
    }

    public Map<String, Object> getValues() {
        if (values == null)
            throw new IllegalStateException("getValues() is possible only if the recommendation requested was set to return property values (invoke setReturnProperties(true))");

        return this.values;
    }

    public Map<String, Object> getReqlEvaluations() {
        if (reqlEvaluations == null)
            throw new IllegalStateException("getReqlEvaluations() is possible only if some ReQL expressions were specified in the request (invoke setReqlExpressions())");
        return this.reqlEvaluations;
    }
}
