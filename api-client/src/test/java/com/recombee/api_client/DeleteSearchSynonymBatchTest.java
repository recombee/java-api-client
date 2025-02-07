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

public class DeleteSearchSynonymBatchTest extends RecombeeTestCase {

    @Test
    public void testDeleteSearchSynonym() throws ApiException {
        Object resp2;
        resp2 = this.client.send(new AddSearchSynonym("sci-fi","science fiction"));

        Request[] requests = new Request[] {
            new DeleteSearchSynonym(((SearchSynonym)resp2).getId()),
            new DeleteSearchSynonym("a968271b-d666-4dfb-8a30-f459e564ba7b")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(404,responses[1].getStatusCode());
    }
}
