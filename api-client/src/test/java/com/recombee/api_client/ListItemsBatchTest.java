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

public class ListItemsBatchTest extends RecombeeTestCase {

    @Test
    public void testListItems() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new ListItems(),
            new ListItems()
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertArrayEquals (new Item[]{new Item("entity_id")},((Item []) responses[0].getResponse()));
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(1, ((Item []) responses[1].getResponse()).length);
    }
}
