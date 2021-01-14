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

public class RecommendNextItemsBatchTest extends RecommendationTestCase {

    @Test
    public void testRecommendNextItems() throws ApiException {
        Object resp2;
        resp2 = this.client.send(new RecommendItemsToUser("entity_id",3).setReturnProperties(true));

        Request[] requests = new Request[] {
            new RecommendNextItems(((RecommendationResponse)resp2).getRecommId(),3),
            new RecommendNextItems(((RecommendationResponse)resp2).getRecommId(),3)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(3, ((RecommendationResponse ) responses[0].getResponse()).getRecomms().length);
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(3, ((RecommendationResponse ) responses[1].getResponse()).getRecomms().length);
    }
}
