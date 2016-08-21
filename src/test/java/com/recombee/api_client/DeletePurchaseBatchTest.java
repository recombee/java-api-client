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

public class DeletePurchaseBatchTest extends InteractionsTestCase {

    @Test
    public void testDeletePurchase() throws ApiException {
        Request[] requests = new Request[] {
            new DeletePurchase("user","item").setTimestamp(new Date(0)),
            new DeletePurchase("user","item")
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(404,responses[1].getStatusCode());
    }
}
