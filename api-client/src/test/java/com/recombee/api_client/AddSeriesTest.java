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
        String  resp;
        Object resp2;
        // it 'does not fail with valid entity id'
        resp = this.client.send(new AddSeries("valid_id"));
        // it 'fails with invalid entity id'
        try {
            this.client.send(new AddSeries("***not_valid$$$"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'really stores entity to the system'
        resp = this.client.send(new AddSeries("valid_id2"));
        try {
            this.client.send(new AddSeries("valid_id2"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
