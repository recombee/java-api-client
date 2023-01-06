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

public class GetSegmentationTest extends RecombeeTestCase {

    @Test
    public void testGetSegmentation() throws ApiException {
        Segmentation  resp;
        Object resp2;
        // it 'gets existing segmentation'
        resp2 = this.client.send(new CreatePropertyBasedSegmentation("seg1","items","str_property"));
        resp = this.client.send(new GetSegmentation("seg1"));
        assertEquals ("seg1",resp.getSegmentationId());
    }
}
