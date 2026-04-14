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

public class RecommendNextItemSegmentsTest extends RecombeeTestCase {

    @Test
    public void testRecommendNextItemSegments() throws ApiException {
        RecommendationResponse  resp;
        Object resp2;
        // it 'rejects request with invalid recommId'
        try {
            this.client.send(new RecommendNextItemSegments("invalid_recomm_id",5));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'rejects request to recommId which does not return item-segments'
        resp2 = this.client.send(new RecommendItemsToUser("entity_id",3));
        try {
            this.client.send(new RecommendNextItemSegments(((RecommendationResponse)resp2).getRecommId(),5));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
    }
}
