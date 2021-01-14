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

public class RecommendNextItemsTest extends RecommendationTestCase {

    @Test
    public void testRecommendNextItems() throws ApiException {
        RecommendationResponse  resp;
        Object resp2;
        // it 'recommends'
        resp2 = this.client.send(new RecommendItemsToUser("entity_id",3).setReturnProperties(true));
        resp = this.client.send(new RecommendNextItems(((RecommendationResponse)resp2).getRecommId(),3));
        assertEquals(3, resp.getRecomms().length);
        resp = this.client.send(new RecommendNextItems(((RecommendationResponse)resp2).getRecommId(),3));
        assertEquals(3, resp.getRecomms().length);
    }
}
