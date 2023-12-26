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
public class UpdateManualReqlSegmentation extends Request {

    /**
     * ID of the updated Segmentation
     */
    protected String segmentationId;
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
    public UpdateManualReqlSegmentation (String segmentationId) {
        this.segmentationId = segmentationId;
        this.timeout = 10000;
    }

    /**
     * @param title Human-readable name that is shown in the Recombee Admin UI.
     */
    public UpdateManualReqlSegmentation setTitle(String title) {
         this.title = title;
         return this;
    }

    /**
     * @param description Description that is shown in the Recombee Admin UI.
     */
    public UpdateManualReqlSegmentation setDescription(String description) {
         this.description = description;
         return this;
    }

    public String getSegmentationId() {
         return this.segmentationId;
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
        if (this.title!=null) {
            params.put("title", this.title);
        }
        if (this.description!=null) {
            params.put("description", this.description);
        }
        return params;
    }

}
