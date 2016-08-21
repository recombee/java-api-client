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

public class ListSeriesItemsTest extends RecombeeTestCase {

    @Test
    public void testListSeriesItems() throws ApiException {
        ListSeriesItems req;
        Request req2;
        SeriesItem [] resp;
        // it 'lists set items'
        req = new ListSeriesItems("entity_id");
        resp = this.client.send(req);
        assertEquals(1, resp.length);
        assertEquals ("entity_id",resp[0].getItemId());
        assertEquals ("item",resp[0].getItemType());
    }
}
