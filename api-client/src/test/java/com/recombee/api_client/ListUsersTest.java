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

public class ListUsersTest extends RecombeeTestCase {

    @Test
    public void testListUsers() throws ApiException {
        User [] resp;
        Object resp2;
        // it 'lists entities'
        waitForDataProcessing();
        resp = this.client.send(new ListUsers());
        assertArrayEquals (new User[]{new User("entity_id")},resp);
        // it 'return properties'
        waitForDataProcessing();
        resp = this.client.send(new ListUsers().setReturnProperties(true));
        assertEquals(1, resp.length);
    }
}
