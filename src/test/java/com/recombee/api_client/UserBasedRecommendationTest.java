package com.recombee.api_client;


import com.recombee.api_client.api_requests.Batch;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.api_requests.Request;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class UserBasedRecommendationTest extends RecommendationTestCase {

    @Test
    public void testBasicRecomm() throws ApiException {
        UserBasedRecommendation req = new UserBasedRecommendation("entity_id", 9);
        Recommendation[] response = this.client.send(req);
        assertEquals(9, response.length);
    }

    @Test
    public void testRotation() throws ApiException {
        UserBasedRecommendation req = new UserBasedRecommendation("entity_id", 9);
        Recommendation[] recommended1 = this.client.send(req);
        assertEquals(9, recommended1.length);

        UserBasedRecommendation req2 = new UserBasedRecommendation("entity_id", 9).setRotationRate(1);
        Recommendation[] recommended2 = this.client.send(req2);
        assertEquals(9, recommended2.length);

        ArrayList<String> ids1 = new ArrayList<String>();
        for(Recommendation r: recommended1) ids1.add(r.getId());
        ArrayList<String> ids2 = new ArrayList<String>();
        for(Recommendation r: recommended2) ids2.add(r.getId());

        for(String id: ids1) {
            assertFalse(ids2.contains(id));
        }

    }

    @Test
    public void testInBatch() throws ApiException {
        final int NUM = 25;
        ArrayList<Request> reqs = new ArrayList<Request>();
        for(int i=0;i<NUM;i++) reqs.add(new UserBasedRecommendation("entity_id", 9));
        this.client.send(new Batch(reqs));

    }

    @Test
    public void testReturningProperties() throws ApiException {
        UserBasedRecommendation req = new UserBasedRecommendation("entity_id", 9).setReturnProperties(true).setIncludedProperties(new String[]{"answer", "id2", "empty"});
        Recommendation[] recommended = this.client.send(req);
        for(Recommendation r: recommended) {
            assertEquals(r.getId(), r.getValues().get("id2"));
            assertEquals(42, r.getValues().get("answer"));
            assertTrue(r.getValues().containsKey("empty"));
        }
        UserBasedRecommendation req2 = new UserBasedRecommendation("entity_id", 9).setReturnProperties(true).setIncludedProperties(new String[]{"answer", "id2"});
        Recommendation[] recommended2 = this.client.send(req2);
        for(Recommendation r: recommended2) {
            assertEquals(r.getId(), r.getValues().get("id2"));
            assertEquals(42, r.getValues().get("answer"));
            assertFalse(r.getValues().containsKey("empty"));
        }
    }
}