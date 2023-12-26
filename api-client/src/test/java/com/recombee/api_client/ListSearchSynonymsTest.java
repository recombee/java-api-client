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

public class ListSearchSynonymsTest extends RecombeeTestCase {

    @Test
    public void testListSearchSynonyms() throws ApiException {
        ListSearchSynonymsResponse  resp;
        Object resp2;
        // it 'lists search synonyms'
        resp2 = this.client.send(new AddSearchSynonym("sci-fi","science fiction"));
        resp = this.client.send(new ListSearchSynonyms());
        assertEquals(1, resp.getSynonyms().length);
        resp = this.client.send(new ListSearchSynonyms().setCount(10).setOffset(1));
        assertEquals(0, resp.getSynonyms().length);
    }
}
