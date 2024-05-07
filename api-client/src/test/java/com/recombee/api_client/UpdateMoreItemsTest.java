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

public class UpdateMoreItemsTest extends RecombeeTestCase {

    @Test
    public void testUpdateMoreItems() throws ApiException {
        UpdateMoreItemsResponse  resp;
        Object resp2;
        // it 'updates more items'
        resp = this.client.send(new UpdateMoreItems("'int_property' == 42",new HashMap<String, Object>(){{put("int_property",77);}}));
        assertEquals(1, resp.getItemIds().length);
        assertEquals (1,resp.getCount());
    }
}
