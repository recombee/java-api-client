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

public class RemoveFromSeriesTest extends RecombeeTestCase {

    @Test
    public void testRemoveFromSeries() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail when removing item that is contained in the set'
        resp = this.client.send(new RemoveFromSeries("entity_id","item","entity_id"));
        // it 'fails when removing item that is not contained in the set'
        try {
            this.client.send(new RemoveFromSeries("entity_id","item","not_contained"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
