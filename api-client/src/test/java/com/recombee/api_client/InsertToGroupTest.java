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
        String  resp;
        Object resp2;
        // it 'does not fail when inserting existing item into existing set'
        resp2 = this.client.send(new AddItem("new_item"));
        resp = this.client.send(new InsertToGroup("entity_id","item","new_item"));
        // it 'does not fail when cascadeCreate is used'
        resp = this.client.send(new InsertToGroup("new_set","item","new_item2").setCascadeCreate(true));
        // it 'really inserts item to the set'
        resp2 = this.client.send(new AddItem("new_item3"));
        resp = this.client.send(new InsertToGroup("entity_id","item","new_item3"));
        try {
            this.client.send(new InsertToGroup("entity_id","item","new_item3"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
