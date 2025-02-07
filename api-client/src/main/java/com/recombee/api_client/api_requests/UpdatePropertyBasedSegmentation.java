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
 * Updates a Property Based Segmentation
 */
public class UpdatePropertyBasedSegmentation extends Request {

    /**
     * ID of the updated Segmentation
     */
    protected String segmentationId;
    /**
     * Name of the property on which the Segmentation should be based
     */
    protected String propertyName;
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
    public UpdatePropertyBasedSegmentation (String segmentationId) {
        this.segmentationId = segmentationId;
        this.timeout = 10000;
    }

    /**
     * @param propertyName Name of the property on which the Segmentation should be based
     */
    public UpdatePropertyBasedSegmentation setPropertyName(String propertyName) {
         this.propertyName = propertyName;
         return this;
    }

    /**
     * @param title Human-readable name that is shown in the Recombee Admin UI.
     */
    public UpdatePropertyBasedSegmentation setTitle(String title) {
         this.title = title;
         return this;
    }

    /**
     * @param description Description that is shown in the Recombee Admin UI.
     */
    public UpdatePropertyBasedSegmentation setDescription(String description) {
         this.description = description;
         return this;
    }

    public String getSegmentationId() {
         return this.segmentationId;
    }

    public String getPropertyName() {
         return this.propertyName;
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
        return String.format("/segmentations/property-based/%s", this.segmentationId);
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
        if (this.propertyName!=null) {
            params.put("propertyName", this.propertyName);
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
