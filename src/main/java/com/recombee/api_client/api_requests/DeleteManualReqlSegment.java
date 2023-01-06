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
 * Delete a Segment from a Manual ReQL Segmentation.
 */
public class DeleteManualReqlSegment extends Request {

    /**
     * ID of the Segmentation from which the Segment should be deleted
     */
    protected String segmentationId;
    /**
     * ID of the Segment that should be deleted
     */
    protected String segmentId;

    /**
     * Construct the request
     * @param segmentationId ID of the Segmentation from which the Segment should be deleted
     * @param segmentId ID of the Segment that should be deleted
     */
    public DeleteManualReqlSegment (String segmentationId,String segmentId) {
        this.segmentationId = segmentationId;
        this.segmentId = segmentId;
        this.timeout = 10000;
    }


    public String getSegmentationId() {
         return this.segmentationId;
    }

    public String getSegmentId() {
         return this.segmentId;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.DELETE;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/segmentations/manual-reql/%s/segments/%s", this.segmentationId,this.segmentId);
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
        return params;
    }

}
