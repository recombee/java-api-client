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
        ListUsers req;
        Request req2;
        User [] resp;
        // it 'lists entities'
        req = new ListUsers();
        resp = this.client.send(req);
        assertArrayEquals (new User[]{new User("entity_id")},resp);
        // it 'return properties'
        req = new ListUsers();
        resp = this.client.send(req);
        assertEquals(1, resp.length);
    }
}
