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

public class SetViewPortionTest extends RecombeeTestCase {

    @Test
    public void testSetViewPortion() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with cascadeCreate'
        resp = this.client.send(new SetViewPortion("u_id","i_id",1).setCascadeCreate(true).setAdditionalData(new HashMap<String, Object>(){{put("answer",42);}}));
        // it 'does not fail with existing item and user'
        resp = this.client.send(new SetViewPortion("entity_id","entity_id",0));
        // it 'fails with nonexisting item id'
        try {
            this.client.send(new SetViewPortion("entity_id","nonex_id",1));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with nonexisting user id'
        try {
            this.client.send(new SetViewPortion("nonex_id","entity_id",0.5));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with invalid time'
        try {
            this.client.send(new SetViewPortion("entity_id","entity_id",0).setTimestamp(new Date(-15)));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with invalid portion'
        try {
            this.client.send(new SetViewPortion("entity_id","entity_id",-2));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with invalid sessionId'
        try {
            this.client.send(new SetViewPortion("entity_id","entity_id",0.7).setSessionId("a****"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
    }
}
