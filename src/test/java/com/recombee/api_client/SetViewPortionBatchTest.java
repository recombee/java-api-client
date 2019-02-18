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

public class SetViewPortionBatchTest extends RecombeeTestCase {

    @Test
    public void testSetViewPortion() throws ApiException {
        Request[] requests = new Request[] {
            new SetViewPortion("u_id","i_id",1).setCascadeCreate(true).setAdditionalData(new HashMap<String, Object>(){{put("answer",42);}}),
            new SetViewPortion("entity_id","entity_id",0),
            new SetViewPortion("entity_id","nonex_id",1),
            new SetViewPortion("nonex_id","entity_id",0.5),
            new SetViewPortion("entity_id","entity_id",0).setTimestamp(new Date(-15)),
            new SetViewPortion("entity_id","entity_id",-2),
            new SetViewPortion("entity_id","entity_id",0.7).setSessionId("a****")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(404,responses[2].getStatusCode());
        assertEquals(404,responses[3].getStatusCode());
        assertEquals(400,responses[4].getStatusCode());
        assertEquals(400,responses[5].getStatusCode());
        assertEquals(400,responses[6].getStatusCode());
    }
}
