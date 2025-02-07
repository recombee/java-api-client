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

public class SetItemValuesBatchTest extends RecombeeTestCase {

    @Test
    public void testSetItemValues() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new SetItemValues("entity_id",new HashMap<String, Object>(){{put("int_property",5);}}),
            new SetItemValues("entity_id",new HashMap<String, Object>(){{put("str_property","šřžذ的‎");}}),
            new SetItemValues("entity_id",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");}}),
            new SetItemValues("new_entity",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");put("!cascadeCreate",true);}}),
            new SetItemValues("new_entity2",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");}}).setCascadeCreate(true),
            new SetItemValues("nonexisting",new HashMap<String, Object>(){{put("int_property",5);}})
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(200,responses[2].getStatusCode());
        assertEquals(200,responses[3].getStatusCode());
        assertEquals(200,responses[4].getStatusCode());
        assertEquals(404,responses[5].getStatusCode());
    }
}
