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

public class DeleteViewPortionTest extends InteractionsTestCase {

    @Test
    public void testDeleteViewPortion() throws ApiException {
        DeleteViewPortion req;
        Request req2;
        String  resp;
        // it 'does not fail with existing entity id'
        req = new DeleteViewPortion("user","item");
        resp = this.client.send(req);
        req = new DeleteViewPortion("user","item");
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
