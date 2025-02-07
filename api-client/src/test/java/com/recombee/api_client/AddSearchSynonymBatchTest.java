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

public class AddSearchSynonymBatchTest extends RecombeeTestCase {

    @Test
    public void testAddSearchSynonym() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new AddSearchSynonym("sci-fi","science fiction").setOneWay(true),
            new AddSearchSynonym("sci-fi","science fiction").setOneWay(true)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(201,responses[0].getStatusCode());
        assertEquals ("sci-fi",((SearchSynonym ) responses[0].getResponse()).getTerm());
        assertEquals ("science fiction",((SearchSynonym ) responses[0].getResponse()).getSynonym());
        assertEquals(409,responses[1].getStatusCode());
    }
}
