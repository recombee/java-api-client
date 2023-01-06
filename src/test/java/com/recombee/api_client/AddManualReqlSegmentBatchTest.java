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

public class AddManualReqlSegmentBatchTest extends RecombeeTestCase {

    @Test
    public void testAddManualReqlSegment() throws ApiException {
        Object resp2;
        resp2 = this.client.send(new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes"));

        Request[] requests = new Request[] {
            new AddManualReqlSegment("seg1","first-segment","'str_property' != null").setTitle("First Segment")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
    }
}
