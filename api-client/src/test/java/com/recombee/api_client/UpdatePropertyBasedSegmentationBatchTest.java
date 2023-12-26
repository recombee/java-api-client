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

public class UpdatePropertyBasedSegmentationBatchTest extends RecombeeTestCase {

    @Test
    public void testUpdatePropertyBasedSegmentation() throws ApiException {
        Object resp2;
        resp2 = this.client.send(new CreatePropertyBasedSegmentation("seg1","items","str_property"));

        Request[] requests = new Request[] {
            new UpdatePropertyBasedSegmentation("seg1").setTitle("New title").setPropertyName("str_property").setDescription("Updated")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
    }
}
