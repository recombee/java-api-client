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

public class GetUserPropertyInfoTest extends RecombeeTestCase {

    @Test
    public void testGetUserPropertyInfo() throws ApiException {
        GetUserPropertyInfo req;
        Request req2;
        PropertyInfo  resp;
        // it 'does not fail with existing properties'
        req = new GetUserPropertyInfo("int_property");
        resp = this.client.send(req);
        assertEquals ("int",resp.getType());
        req = new GetUserPropertyInfo("str_property");
        resp = this.client.send(req);
        assertEquals ("string",resp.getType());
    }
}
