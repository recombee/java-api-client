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

public class ListSegmentationsBatchTest extends RecombeeTestCase {

    @Test
    public void testListSegmentations() throws ApiException {
        Object resp2;
        resp2 = this.client.send(new CreatePropertyBasedSegmentation("seg1","items","str_property"));

        Request[] requests = new Request[] {
            new ListSegmentations("items")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(1, ((ListSegmentationsResponse ) responses[0].getResponse()).getSegmentations().length);
    }
}
