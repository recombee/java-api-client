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

public class SetUserValuesTest extends RecombeeTestCase {

    @Test
    public void testSetUserValues() throws ApiException {
        SetUserValues req;
        Request req2;
        String  resp;
        // it 'does not fail with existing entity and property'
        req = new SetUserValues("entity_id",new HashMap<String, Object>(){{put("int_property",5);}});
        resp = this.client.send(req);
        // it 'does not fail with non-ASCII string'
        req = new SetUserValues("entity_id",new HashMap<String, Object>(){{put("str_property","šřžذ的‎");}});
        resp = this.client.send(req);
        // it 'sets multiple properties'
        req = new SetUserValues("entity_id",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");}});
        resp = this.client.send(req);
        // it 'does not fail with !cascadeCreate'
        req = new SetUserValues("new_entity",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");put("!cascadeCreate",true);}});
        resp = this.client.send(req);
        // it 'does not fail with cascadeCreate optional parameter'
        req = new SetUserValues("new_entity2",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");}}).setCascadeCreate(true);
        resp = this.client.send(req);
        // it 'fails with nonexisting entity'
        req = new SetUserValues("nonexisting",new HashMap<String, Object>(){{put("int_property",5);}});
        try {
            this.client.send(req);
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
