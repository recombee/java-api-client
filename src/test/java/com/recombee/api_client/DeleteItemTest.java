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

public class DeleteItemTest extends RecombeeTestCase {

    @Test
    public void testDeleteItem() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with existing entity id'
        resp = this.client.send(new DeleteItem("entity_id"));
        try {
            this.client.send(new DeleteItem("entity_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with invalid entity id'
        try {
            this.client.send(new DeleteItem("***not_valid$$$"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with non-existing entity'
        try {
            this.client.send(new DeleteItem("valid_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
