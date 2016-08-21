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

public class ListGroupsTest extends RecombeeTestCase {

    @Test
    public void testListGroups() throws ApiException {
        ListGroups req;
        Request req2;
        Group [] resp;
        // it 'lists entities'
        req = new ListGroups();
        resp = this.client.send(req);
        assertArrayEquals (new Group[]{new Group("entity_id")},resp);
    }
}
