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
        String  resp;
        Object resp2;
        // it 'does not fail with existing entity and property'
        resp = this.client.send(new SetUserValues("entity_id",new HashMap<String, Object>(){{put("int_property",5);}}));
        // it 'does not fail with non-ASCII string'
        resp = this.client.send(new SetUserValues("entity_id",new HashMap<String, Object>(){{put("str_property","šřžذ的‎");}}));
        // it 'sets multiple properties'
        resp = this.client.send(new SetUserValues("entity_id",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");}}));
        // it 'does not fail with !cascadeCreate'
        resp = this.client.send(new SetUserValues("new_entity",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");put("!cascadeCreate",true);}}));
        // it 'does not fail with cascadeCreate optional parameter'
        resp = this.client.send(new SetUserValues("new_entity2",new HashMap<String, Object>(){{put("int_property",5);put("str_property","test");}}).setCascadeCreate(true));
        // it 'fails with nonexisting entity'
        try {
            this.client.send(new SetUserValues("nonexisting",new HashMap<String, Object>(){{put("int_property",5);}}));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
