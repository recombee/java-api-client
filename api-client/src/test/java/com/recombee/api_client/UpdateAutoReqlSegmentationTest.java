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

public class UpdateAutoReqlSegmentationTest extends RecombeeTestCase {

    @Test
    public void testUpdateAutoReqlSegmentation() throws ApiException {
        String  resp;
        Object resp2;
        // it 'updates auto ReQL segmentation'
        resp2 = this.client.send(new CreateAutoReqlSegmentation("seg1","items","{'str_property'}").setTitle("Test Segmentation").setDescription("For test purposes"));
        resp = this.client.send(new UpdateAutoReqlSegmentation("seg1").setTitle("New title").setExpression("{'str_property' + 'str_property'}").setDescription("Updated"));
    }
}
