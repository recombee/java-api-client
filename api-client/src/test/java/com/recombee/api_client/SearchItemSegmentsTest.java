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

public class SearchItemSegmentsTest extends RecombeeTestCase {

    @Test
    public void testSearchItemSegments() throws ApiException {
        SearchResponse  resp;
        Object resp2;
        // it 'rejects request to scenario which is not set up'
        try {
            this.client.send(new SearchItemSegments("entity_id","query",5).setScenario("scenario1").setCascadeCreate(true));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
    }
}
