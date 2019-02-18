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
        SetViewPortion req;
        Request req2;
        String  resp;
        // it 'does not fail with cascadeCreate'
        req = new SetViewPortion("u_id","i_id",1).setCascadeCreate(true).setAdditionalData(new HashMap<String, Object>(){{put("answer",42);}});
        resp = this.client.send(req);
        // it 'does not fail with existing item and user'
        req = new SetViewPortion("entity_id","entity_id",0);
        resp = this.client.send(req);
        // it 'fails with nonexisting item id'
        req = new SetViewPortion("entity_id","nonex_id",1);
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with nonexisting user id'
        req = new SetViewPortion("nonex_id","entity_id",0.5);
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
        // it 'fails with invalid time'
        req = new SetViewPortion("entity_id","entity_id",0).setTimestamp(new Date(-15));
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with invalid portion'
        req = new SetViewPortion("entity_id","entity_id",-2);
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'fails with invalid sessionId'
        req = new SetViewPortion("entity_id","entity_id",0.7).setSessionId("a****");
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
    }
}
