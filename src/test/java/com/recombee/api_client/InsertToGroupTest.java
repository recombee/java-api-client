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

public class InsertToGroupTest extends RecombeeTestCase {

    @Test
    public void testInsertToGroup() throws ApiException {
        InsertToGroup req;
        Request req2;
        String  resp;
        // it 'does not fail when inserting existing item into existing set'
        req2 = new AddItem("new_item");
        this.client.send(req2);
        req = new InsertToGroup("entity_id","item","new_item");
        resp = this.client.send(req);
        // it 'does not fail when cascadeCreate is used'
        req = new InsertToGroup("new_set","item","new_item2").setCascadeCreate(true);
        resp = this.client.send(req);
        // it 'really inserts item to the set'
        req2 = new AddItem("new_item3");
        this.client.send(req2);
        req = new InsertToGroup("entity_id","item","new_item3");
        resp = this.client.send(req);
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
