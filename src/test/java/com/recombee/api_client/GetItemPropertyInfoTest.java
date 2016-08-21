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

public class GetItemPropertyInfoTest extends RecombeeTestCase {

    @Test
    public void testGetItemPropertyInfo() throws ApiException {
        GetItemPropertyInfo req;
        Request req2;
        PropertyInfo  resp;
        // it 'does not fail with existing properties'
        req = new GetItemPropertyInfo("int_property");
        resp = this.client.send(req);
        assertEquals ("int",resp.getType());
        req = new GetItemPropertyInfo("str_property");
        resp = this.client.send(req);
        assertEquals ("string",resp.getType());
    }
}
