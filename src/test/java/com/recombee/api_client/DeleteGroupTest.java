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

public class DeleteGroupTest extends RecombeeTestCase {

    @Test
    public void testDeleteGroup() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with existing entity id'
        resp = this.client.send(new DeleteGroup("entity_id"));
        try {
            this.client.send(new DeleteGroup("entity_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with invalid entity id'
        try {
            this.client.send(new DeleteGroup("***not_valid$$$"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with non-existing entity'
        try {
            this.client.send(new DeleteGroup("valid_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
