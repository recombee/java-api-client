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

public class ListUserPropertiesTest extends RecombeeTestCase {

    @Test
    public void testListUserProperties() throws ApiException {
        PropertyInfo [] resp;
        Object resp2;
        // it 'lists properties'
        waitForDataProcessing();
        resp = this.client.send(new ListUserProperties());
        assertEquals(2, resp.length);
    }
}
