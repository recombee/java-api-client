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

public class AddItemPropertyTest extends RecombeeTestCase {

    @Test
    public void testAddItemProperty() throws ApiException {
        String  resp;
        Object resp2;
        // it 'does not fail with valid name and type'
        resp = this.client.send(new AddItemProperty("number","int"));
        resp = this.client.send(new AddItemProperty("str","string"));
        // it 'fails with invalid type'
        try {
            this.client.send(new AddItemProperty("prop","integer"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
        // it 'really stores property to the system'
        resp = this.client.send(new AddItemProperty("number2","int"));
        try {
            this.client.send(new AddItemProperty("number2","int"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
        // it 'does not fail with valid property role and metadata'
        resp = this.client.send(new AddItemProperty("title","string").setRole(new PropertyRole("title")));
        // it 'fails with duplicate property role or invalid metadata'
        resp = this.client.send(new AddItemProperty("str4","string").setRole(new PropertyRole("summary")));
        try {
            this.client.send(new AddItemProperty("str4","string").setRole(new PropertyRole("summary")));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(409,ex.getStatusCode());
        }
        try {
            this.client.send(new AddItemProperty("str5","string").setRole(new PropertyRole("titl")));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
