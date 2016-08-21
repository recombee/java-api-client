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

public class MergeUsersTest extends RecombeeTestCase {

    @Test
    public void testMergeUsers() throws ApiException {
        MergeUsers req;
        Request req2;
        String  resp;
        // it 'does not fail with existing users'
        req2 = new AddUser("target");
        this.client.send(req2);
        req = new MergeUsers("target","entity_id");
        resp = this.client.send(req);
        // it 'fails with nonexisting user'
        req = new MergeUsers("nonex_id","entity_id");
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
