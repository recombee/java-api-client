package com.recombee.api_client;


import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.exceptions.ApiException;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class RecommendationTestCase extends  RecombeeTestCase {

    @Override
    @Before
    public void setUp() throws ApiException {
        super.setUp();

        final int NUM = 1000;
        final double PROBABILITY_PURCHASED = 0.007;

        final ArrayList<String> userIds = new ArrayList<String>();
        ArrayList<String> itemIds = new ArrayList<String>();

        for(int i=0;i<NUM; i++) {
            userIds.add(String.format("user-%s", i));
            itemIds.add(String.format("item-%s", i));
        }

        Random r = new Random();
        ArrayList<Request> purchases = new ArrayList<Request>();
        for(String userId: userIds) {
            for(String itemId: itemIds) {
                if(r.nextDouble() < PROBABILITY_PURCHASED) {
                    purchases.add(new AddPurchase(userId, itemId));
                }
            }
        }

        this.client.send(new Batch(new Request[]{
                new AddItemProperty("answer", "int"),
                new AddItemProperty("id2", "string"),
                new AddItemProperty("empty", "string")
        }));

        ArrayList<Request> itemRequests= new ArrayList<Request>();
        for(final String itemId: itemIds)
            itemRequests.add(new SetItemValues(itemId, new HashMap<String, Object>() {
                {
                    put("answer", 42);
                    put("id2", itemId);
                    put("!cascadeCreate", true);
                }
            }));

        this.client.send(new Batch(new ArrayList<Request>() {{for(String userId: userIds) add(new AddUser(userId));}}));
        this.client.send(new Batch(itemRequests));
        this.client.send(new Batch(purchases));
    }
}