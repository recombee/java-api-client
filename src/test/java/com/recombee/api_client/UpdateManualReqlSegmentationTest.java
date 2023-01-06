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

public class UpdateManualReqlSegmentationTest extends RecombeeTestCase {

    @Test
    public void testUpdateManualReqlSegmentation() throws ApiException {
        String  resp;
        Object resp2;
        // it 'updates manual ReQL segmentation'
        resp2 = this.client.send(new CreateManualReqlSegmentation("seg1","items").setTitle("Test Segmentation").setDescription("For test purposes"));
        resp = this.client.send(new UpdateManualReqlSegmentation("seg1").setTitle("New title").setDescription("Updated"));
    }
}
