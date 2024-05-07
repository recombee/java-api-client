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
        SearchResponse  resp;
        Object resp2;
        // it 'finds "hello"'
        resp = this.client.send(new SearchItems("entity_id","hell",9));
        assertEquals(1, resp.getRecomms().length);
        // it 'does not find random string'
        resp = this.client.send(new SearchItems("entity_id","sdhskldf",9));
        assertEquals(0, resp.getRecomms().length);
        // it 'returnProperties'
        resp = this.client.send(new SearchItems("entity_id","hell",9).setReturnProperties(true));
        assertEquals(1, resp.getRecomms().length);
    }
}
