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

public class CreateManualReqlSegmentationTest extends RecombeeTestCase {

    @Test
    public void testCreateManualReqlSegmentation() throws ApiException {
        String  resp;
        Object resp2;
        // it 'creates manual ReQL segmentation'
        resp = this.client.send(new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes"));
        try {
            this.client.send(new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
