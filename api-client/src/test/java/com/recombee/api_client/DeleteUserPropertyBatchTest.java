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

public class DeleteUserPropertyBatchTest extends RecombeeTestCase {

    @Test
    public void testDeleteUserProperty() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new DeleteUserProperty("int_property"),
            new DeleteUserProperty("int_property"),
            new DeleteUserProperty("***not_valid$$$"),
            new DeleteUserProperty("not_existing")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(404,responses[1].getStatusCode());
        assertEquals(400,responses[2].getStatusCode());
        assertEquals(404,responses[3].getStatusCode());
    }
}
