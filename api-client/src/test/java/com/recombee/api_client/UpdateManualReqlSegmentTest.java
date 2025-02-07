package com.recombee.api_client;
/*
 This file is auto-generated, do not edit
*/


import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.*;
import com.recombee.api_client.exceptions.ApiException;
import com.recombee.api_client.exceptions.ResponseException;

import java.util.HashMap;
import java.util.Date;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.fail;

public class UpdateManualReqlSegmentTest extends RecombeeTestCase {

    @Test
    public void testUpdateManualReqlSegment() throws ApiException {
        String  resp;
        Object resp2;
        // it 'updates manual ReQL segment'
        resp2 = this.client.send(new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes"));
        resp2 = this.client.send(new AddManualReqlSegment("seg1","first-segment","'str_property' != null").setTitle("First Segment"));
        resp = this.client.send(new UpdateManualReqlSegment("seg1","first-segment","'str_property' == null").setTitle("Updated Segment"));
    }
}
