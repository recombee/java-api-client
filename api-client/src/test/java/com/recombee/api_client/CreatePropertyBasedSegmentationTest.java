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

public class CreatePropertyBasedSegmentationTest extends RecombeeTestCase {

    @Test
    public void testCreatePropertyBasedSegmentation() throws ApiException {
        String  resp;
        Object resp2;
        // it 'creates property based segmentation'
        resp = this.client.send(new CreatePropertyBasedSegmentation("seg1","items","str_property").setTitle("Test Segmentation").setDescription("For test purposes"));
        try {
            this.client.send(new CreatePropertyBasedSegmentation("seg1","items","str_property").setTitle("Test Segmentation").setDescription("For test purposes"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
