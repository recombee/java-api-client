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

public class AddUserBatchTest extends RecombeeTestCase {

    @Test
    public void testAddUser() throws ApiException {
        Request[] requests = new Request[] {
            new AddUser("valid_id"),
            new AddUser("...not_valid..."),
            new AddUser("valid_id2"),
            new AddUser("valid_id2")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals(400,responses[1].getStatusCode());
        assertEquals(201,responses[2].getStatusCode());
        assertEquals(409,responses[3].getStatusCode());
    }
}
