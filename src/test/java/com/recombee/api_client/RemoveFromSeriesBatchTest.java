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

public class RemoveFromSeriesBatchTest extends RecombeeTestCase {

    @Test
    public void testRemoveFromSeries() throws ApiException {
        Request[] requests = new Request[] {
            new RemoveFromSeries("entity_id","item","entity_id",0),
            new RemoveFromSeries("entity_id","item","entity_id",1),
            new RemoveFromSeries("entity_id","item","not_contained",1)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(404,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(404,responses[2].getStatusCode());
    }
}
