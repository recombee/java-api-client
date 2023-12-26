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

public class CreateManualReqlSegmentationBatchTest extends RecombeeTestCase {

    @Test
    public void testCreateManualReqlSegmentation() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes"),
            new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals(409,responses[1].getStatusCode());
    }
}
