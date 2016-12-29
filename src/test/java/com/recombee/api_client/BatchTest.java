package com.recombee.api_client;

import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.*;
import com.recombee.api_client.exceptions.ApiException;
import com.recombee.api_client.exceptions.ResponseException;


import java.util.ArrayList;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class BatchTest extends RecombeeTestCase {

    @Test
    public void testLargeBatch() throws ApiException {

        this.client.send(new ResetDatabase());

        final int NUM = 23650;
        final int INDEX_LIST = 10005;
        final int INDEX_WRONG_REQ = 21121;

        ArrayList<Request> requests = new ArrayList<Request>();
        for (int i = 0; i < NUM; i++)
            requests.add(new AddItem(String.format("item-%s", i)));

        requests.set(INDEX_LIST, new ListItems());
        requests.set(INDEX_WRONG_REQ, new AddUser("žšřč"));

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(NUM, responses.length);

        for(int i=0;i<responses.length;i++)
            if (i != INDEX_LIST && i != INDEX_WRONG_REQ)
                assertEquals(201, responses[i].getStatusCode());

        assertEquals(INDEX_LIST, ((Item[]) responses[INDEX_LIST].getResponse()).length);

        try {
            responses[INDEX_WRONG_REQ].getResponse();
            fail("No exception thrown");
        } catch (ResponseException ex) {
            assertEquals(400,ex.getStatusCode());
        }
    }
}
