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

public class GetUserPropertyInfoBatchTest extends RecombeeTestCase {

    @Test
    public void testGetUserPropertyInfo() throws ApiException {
        Request[] requests = new Request[] {
            new GetUserPropertyInfo("int_property"),
            new GetUserPropertyInfo("str_property")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals ("int",((PropertyInfo ) responses[0].getResponse()).getType());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals ("string",((PropertyInfo ) responses[1].getResponse()).getType());
    }
}
