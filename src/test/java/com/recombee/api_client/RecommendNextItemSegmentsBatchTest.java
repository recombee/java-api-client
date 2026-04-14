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

public class RecommendNextItemSegmentsBatchTest extends RecombeeTestCase {

    @Test
    public void testRecommendNextItemSegments() throws ApiException {
        Object resp2;
        try {
            this.client.send(new RecommendNextItemSegments("invalid_recomm_id",5));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }

        resp2 = this.client.send(new RecommendItemsToUser("entity_id",3));

        Request[] requests = new Request[] {
            new RecommendNextItemSegments(((RecommendationResponse)resp2).getRecommId(),5)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(400,responses[0].getStatusCode());
    }
}
