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

public class ListSearchSynonymsBatchTest extends RecombeeTestCase {

    @Test
    public void testListSearchSynonyms() throws ApiException {
        waitForDataProcessing();
        Object resp2;
        resp2 = this.client.send(new AddSearchSynonym("sci-fi","science fiction"));

        Request[] requests = new Request[] {
            new ListSearchSynonyms(),
            new ListSearchSynonyms().setCount(10).setOffset(1)
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(1, ((ListSearchSynonymsResponse ) responses[0].getResponse()).getSynonyms().length);
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(0, ((ListSearchSynonymsResponse ) responses[1].getResponse()).getSynonyms().length);
    }
}
