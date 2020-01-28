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

public class SearchItemsTest extends RecommendationTestCase {

    @Test
    public void testSearchItems() throws ApiException {
        SearchItems req;
        Request req2;
        SearchResponse  resp;
        // it 'finds "hello"'
        req = new SearchItems("entity_id","hell",9);
        resp = this.client.send(req);
        assertEquals(1, resp.getRecomms().length);
        // it 'does not find random string'
        req = new SearchItems("entity_id","sdhskldf",9);
        resp = this.client.send(req);
        assertEquals(0, resp.getRecomms().length);
        // it 'returnProperties'
        req = new SearchItems("entity_id","hell",9).setReturnProperties(true);
        resp = this.client.send(req);
        assertEquals(1, resp.getRecomms().length);
    }
}
