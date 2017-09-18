package com.recombee.api_client;


import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.exceptions.ApiException;
import org.junit.Before;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Date;

public abstract class InteractionsTestCase extends  RecombeeTestCase {

    @Override
    @Before
    public void setUp() throws ApiException {
        super.setUp();

        Request[] requests = new Request[]{
            new AddUser("user"),
            new AddItem("item"),
            new AddDetailView("user", "item").setTimestamp(new Date(0)),
            new AddPurchase("user", "item").setTimestamp(new Date(0)),
            new AddRating("user", "item", 1).setTimestamp(new Date(0)),
            new AddCartAddition("user", "item").setTimestamp(new Date(0)),
            new AddBookmark("user", "item").setTimestamp(new Date(0)),
            new SetViewPortion("user", "item", 1).setTimestamp(new Date(0))

        };
        this.client.send(new Batch(requests));
    }
}