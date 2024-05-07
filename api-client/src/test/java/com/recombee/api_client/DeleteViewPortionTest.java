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
        String  resp;
        Object resp2;
        // it 'does not fail with existing entity id'
        resp = this.client.send(new DeleteViewPortion("user","item"));
        try {
            this.client.send(new DeleteViewPortion("user","item"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
