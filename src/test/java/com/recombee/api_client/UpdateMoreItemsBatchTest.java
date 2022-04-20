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

public class UpdateMoreItemsBatchTest extends RecombeeTestCase {

    @Test
    public void testUpdateMoreItems() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new UpdateMoreItems("'int_property' == 42",new HashMap<String, Object>(){{put("int_property",77);}})
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(1, ((UpdateMoreItemsResponse ) responses[0].getResponse()).getItemIds().length);
        assertEquals (1,((UpdateMoreItemsResponse ) responses[0].getResponse()).getCount());
    }
}
