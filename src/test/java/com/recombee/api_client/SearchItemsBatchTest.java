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

public class SearchItemsBatchTest extends RecommendationTestCase {

    @Test
    public void testSearchItems() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new SearchItems("entity_id","hell",9),
            new SearchItems("entity_id","sdhskldf",9),
            new SearchItems("entity_id","hell",9).setReturnProperties(true)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(1, ((SearchResponse ) responses[0].getResponse()).getRecomms().length);
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(0, ((SearchResponse ) responses[1].getResponse()).getRecomms().length);
        assertEquals(200,responses[2].getStatusCode());
        assertEquals(1, ((SearchResponse ) responses[2].getResponse()).getRecomms().length);
    }
}
