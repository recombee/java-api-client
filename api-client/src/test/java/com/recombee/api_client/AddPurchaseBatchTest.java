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

public class AddPurchaseBatchTest extends RecombeeTestCase {

    @Test
    public void testAddPurchase() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new AddPurchase("u_id","i_id").setCascadeCreate(true).setAdditionalData(new HashMap<String, Object>(){{put("answer",42);}}),
            new AddPurchase("entity_id","entity_id"),
            new AddPurchase("entity_id","entity_id").setTimestamp(parseDate("2013-10-29T09:38:41.341Z")),
            new AddPurchase("entity_id","nonex_id"),
            new AddPurchase("nonex_id","entity_id"),
            new AddPurchase("entity_id","entity_id").setTimestamp(new Date(-15)),
            new AddPurchase("u_id2","i_id2").setCascadeCreate(true).setTimestamp(new Date(5)),
            new AddPurchase("u_id2","i_id2").setCascadeCreate(true).setTimestamp(new Date(5))
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(200,responses[2].getStatusCode());
        assertEquals(404,responses[3].getStatusCode());
        assertEquals(404,responses[4].getStatusCode());
        assertEquals(400,responses[5].getStatusCode());
        assertEquals(200,responses[6].getStatusCode());
        assertEquals(409,responses[7].getStatusCode());
    }
}
