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

public class InsertToGroupBatchTest extends RecombeeTestCase {

    @Test
    public void testInsertToGroup() throws ApiException {
        Request[] requests = new Request[] {
            new AddItem("new_item"),
            new InsertToGroup("entity_id","item","new_item"),
            new InsertToGroup("new_set","item","new_item2").setCascadeCreate(true),
            new AddItem("new_item3"),
            new InsertToGroup("entity_id","item","new_item3"),
            new InsertToGroup("entity_id","item","new_item3")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(200,responses[2].getStatusCode());
        assertEquals(201,responses[3].getStatusCode());
        assertEquals(200,responses[4].getStatusCode());
        assertEquals(409,responses[5].getStatusCode());
    }
}
