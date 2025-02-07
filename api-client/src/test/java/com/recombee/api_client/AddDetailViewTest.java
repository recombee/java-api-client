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

public class AddDetailViewTest extends RecombeeTestCase {

    @Test
    public void testAddDetailView() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with cascadeCreate'
        resp = this.client.send(new AddDetailView("u_id","i_id").setCascadeCreate(true).setAdditionalData(new HashMap<String, Object>(){{put("answer",42);}}));
        // it 'does not fail with existing item and user'
        resp = this.client.send(new AddDetailView("entity_id","entity_id"));
        // it 'does not fail with valid timestamp'
        resp = this.client.send(new AddDetailView("entity_id","entity_id").setTimestamp(parseDate("2013-10-29T09:38:41.341Z")));
        // it 'fails with nonexisting item id'
        try {
            this.client.send(new AddDetailView("entity_id","nonex_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with nonexisting user id'
        try {
            this.client.send(new AddDetailView("nonex_id","entity_id"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'really stores interaction to the system'
        resp = this.client.send(new AddDetailView("u_id2","i_id2").setCascadeCreate(true).setTimestamp(new Date(5)));
        try {
            this.client.send(new AddDetailView("u_id2","i_id2").setCascadeCreate(true).setTimestamp(new Date(5)));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
    }
}
