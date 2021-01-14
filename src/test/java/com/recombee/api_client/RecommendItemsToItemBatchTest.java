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

public class RecommendItemsToItemBatchTest extends RecommendationTestCase {

    @Test
    public void testRecommendItemsToItem() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new RecommendItemsToItem("entity_id","entity_id",9),
            new RecommendItemsToItem("nonexisting","entity_id",9).setCascadeCreate(true),
            new RecommendItemsToItem("nonexisting2","entity_id",9).setCascadeCreate(true).setExpertSettings(new HashMap<String, Object>(){{}})
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(200,responses[2].getStatusCode());
    }
}
