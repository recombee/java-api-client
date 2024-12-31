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

public class InsertToSeriesBatchTest extends RecombeeTestCase {

    @Test
    public void testInsertToSeries() throws ApiException {
        Object resp2;
        resp2 = this.client.send(new AddItem("new_item"));

        resp2 = this.client.send(new AddItem("new_item3"));

        Request[] requests = new Request[] {
            new InsertToSeries("entity_id","item","new_item",3),
            new InsertToSeries("new_set","item","new_item2",1).setCascadeCreate(true),
            new InsertToSeries("entity_id","item","new_item3",2),
            new InsertToSeries("entity_id","item","new_item3",2)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(200,responses[2].getStatusCode());
        assertEquals(409,responses[3].getStatusCode());
    }
}
