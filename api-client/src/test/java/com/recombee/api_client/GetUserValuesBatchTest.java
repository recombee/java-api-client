package com.recombee.api_client;

import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.*;
import com.recombee.api_client.exceptions.ApiException;


import java.util.Map;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class GetUserValuesBatchTest extends RecombeeTestCase {

    @Test
    public void testGetUserValues() throws ApiException {
        Request[] requests = new Request[] {
            new GetUserValues("entity_id")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
                assertEquals (42,((Map<String, Object>) responses[0].getResponse()).get("int_property"));
                assertEquals ("hello",((Map<String, Object>) responses[0].getResponse()).get("str_property"));
    }
}
