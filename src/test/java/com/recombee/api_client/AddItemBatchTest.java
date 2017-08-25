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

public class AddItemBatchTest extends RecombeeTestCase {

    @Test
    public void testAddItem() throws ApiException {
        Request[] requests = new Request[] {
            new AddItem("valid_id"),
            new AddItem("...not_valid..."),
            new AddItem("valid_id2"),
            new AddItem("valid_id2")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals(400,responses[1].getStatusCode());
        assertEquals(201,responses[2].getStatusCode());
        assertEquals(409,responses[3].getStatusCode());
    }
}
