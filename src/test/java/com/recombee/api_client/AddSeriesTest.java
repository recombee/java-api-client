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

public class AddSeriesTest extends RecombeeTestCase {

    @Test
    public void testAddSeries() throws ApiException {
        AddSeries req;
        Request req2;
        String  resp;
        // it 'does not fail with valid entity id'
        req = new AddSeries("valid_id");
        resp = this.client.send(req);
        // it 'fails with invalid entity id'
        req = new AddSeries("not_valid_id-*.?!");
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'really stores entity to the system'
        req = new AddSeries("valid_id2");
        resp = this.client.send(req);
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
