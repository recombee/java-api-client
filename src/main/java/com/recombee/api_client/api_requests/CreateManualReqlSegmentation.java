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
 * Segment the items using multiple [ReQL](https://docs.recombee.com/reql.html) filters.
 * Use the Add Manual ReQL Items Segment endpoint to create the individual segments.
 */
public class CreateManualReqlSegmentation extends Request {

    /**
     * ID of the newly created Segmentation
     */
    protected String segmentationId;
    /**
     * What type of data should be segmented. Currently only `items` are supported.
     */
    protected String sourceType;
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
     * @param segmentationId ID of the newly created Segmentation
     * @param sourceType What type of data should be segmented. Currently only `items` are supported.
     */
    public CreateManualReqlSegmentation (String segmentationId,String sourceType) {
        this.segmentationId = segmentationId;
        this.sourceType = sourceType;
        this.timeout = 10000;
    }

    /**
     * @param title Human-readable name that is shown in the Recombee Admin UI.
     */
    public CreateManualReqlSegmentation setTitle(String title) {
         this.title = title;
         return this;
    }

    /**
     * @param description Description that is shown in the Recombee Admin UI.
     */
    public CreateManualReqlSegmentation setDescription(String description) {
         this.description = description;
         return this;
    }

    public String getSegmentationId() {
         return this.segmentationId;
    }

    public String getSourceType() {
         return this.sourceType;
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
        return HTTPMethod.PUT;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/segmentations/manual-reql/%s", this.segmentationId);
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
        params.put("sourceType", this.sourceType);
        if (this.title!=null) {
            params.put("title", this.title);
        }
        if (this.description!=null) {
            params.put("description", this.description);
        }
        return params;
    }

}
