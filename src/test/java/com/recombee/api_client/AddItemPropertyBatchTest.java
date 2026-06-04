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

public class AddItemPropertyBatchTest extends RecombeeTestCase {

    @Test
    public void testAddItemProperty() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new AddItemProperty("number","int"),
            new AddItemProperty("str","string"),
            new AddItemProperty("prop","integer"),
            new AddItemProperty("number2","int"),
            new AddItemProperty("number2","int"),
            new AddItemProperty("title","string").setRole(new PropertyRole("title")),
            new AddItemProperty("str4","string").setRole(new PropertyRole("summary")),
            new AddItemProperty("str4","string").setRole(new PropertyRole("summary")),
            new AddItemProperty("str5","string").setRole(new PropertyRole("titl"))
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals(201,responses[1].getStatusCode());
        assertEquals(400,responses[2].getStatusCode());
        assertEquals(201,responses[3].getStatusCode());
        assertEquals(409,responses[4].getStatusCode());
        assertEquals(201,responses[5].getStatusCode());
        assertEquals(201,responses[6].getStatusCode());
        assertEquals(409,responses[7].getStatusCode());
        assertEquals(404,responses[8].getStatusCode());
    }
}
