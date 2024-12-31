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
 * Update an existing Segmentation.
 */
public class UpdateAutoReqlSegmentation extends Request {

    /**
     * ID of the updated Segmentation
     */
    protected String segmentationId;
    /**
     * ReQL expression that returns for each item a set with IDs of segments to which the item belongs
     */
    protected String expression;
    /**
     * Human-readable name that is shown in the Recombee Admin UI.
     */
    protected String title;
    /**
     * Description that is shown in the Recombee Admin UI.
     */
    protected String description;

    /**
     * Construct the request
     * @param segmentationId ID of the updated Segmentation
     */
    public UpdateAutoReqlSegmentation (String segmentationId) {
        this.segmentationId = segmentationId;
        this.timeout = 10000;
    }

    /**
     * @param expression ReQL expression that returns for each item a set with IDs of segments to which the item belongs
     */
    public UpdateAutoReqlSegmentation setExpression(String expression) {
         this.expression = expression;
         return this;
    }

    /**
     * @param title Human-readable name that is shown in the Recombee Admin UI.
     */
    public UpdateAutoReqlSegmentation setTitle(String title) {
         this.title = title;
         return this;
    }

    /**
     * @param description Description that is shown in the Recombee Admin UI.
     */
    public UpdateAutoReqlSegmentation setDescription(String description) {
         this.description = description;
         return this;
    }

    public String getSegmentationId() {
         return this.segmentationId;
    }

    public String getExpression() {
         return this.expression;
    }

    public String getTitle() {
         return this.title;
    }

    public String getDescription() {
         return this.description;
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
        return String.format("/segmentations/auto-reql/%s", this.segmentationId);
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
        if (this.expression!=null) {
            params.put("expression", this.expression);
        }
        if (this.title!=null) {
            params.put("title", this.title);
        }
        if (this.description!=null) {
            params.put("description", this.description);
        }
        return params;
    }

}
