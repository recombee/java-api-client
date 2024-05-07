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

public class DeleteSearchSynonymTest extends RecombeeTestCase {

    @Test
    public void testDeleteSearchSynonym() throws ApiException {
        String  resp;
        Object resp2;
        // it 'deletes search synonym'
        resp2 = this.client.send(new AddSearchSynonym("sci-fi","science fiction"));
        resp = this.client.send(new DeleteSearchSynonym(((SearchSynonym)resp2).getId()));
        try {
            this.client.send(new DeleteSearchSynonym("a968271b-d666-4dfb-8a30-f459e564ba7b"));
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(404,ex.getStatusCode());
        }
    }
}
