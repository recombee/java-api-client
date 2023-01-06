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

public class RecommendItemSegmentsToItemSegmentBatchTest extends RecombeeTestCase {

    @Test
    public void testRecommendItemSegmentsToItemSegment() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new RecommendItemSegmentsToItemSegment("segment_id","entity_id",5).setScenario("scenario1").setCascadeCreate(true)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(400,responses[0].getStatusCode());
    }
}
