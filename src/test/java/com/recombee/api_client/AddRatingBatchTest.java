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

public class AddRatingBatchTest extends RecombeeTestCase {

    @Test
    public void testAddRating() throws ApiException {
        Request[] requests = new Request[] {
            new AddRating("u_id","i_id",1).setCascadeCreate(true).setAdditionalData(new HashMap<String, Object>(){{put("answer",42);}}),
            new AddRating("entity_id","entity_id",0),
            new AddRating("entity_id","nonex_id",-1),
            new AddRating("nonex_id","entity_id",0.5),
            new AddRating("entity_id","entity_id",0).setTimestamp(new Date(-15)),
            new AddRating("entity_id","entity_id",-2),
            new AddRating("u_id","i_id",0.3).setCascadeCreate(true).setTimestamp(new Date(5)),
            new AddRating("u_id","i_id",0.3).setCascadeCreate(true).setTimestamp(new Date(5))
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(404,responses[2].getStatusCode());
        assertEquals(404,responses[3].getStatusCode());
        assertEquals(400,responses[4].getStatusCode());
        assertEquals(400,responses[5].getStatusCode());
        assertEquals(200,responses[6].getStatusCode());
        assertEquals(409,responses[7].getStatusCode());
    }
}
