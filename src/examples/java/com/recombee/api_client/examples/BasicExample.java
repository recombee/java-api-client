package com.recombee.api_client.examples;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import java.util.ArrayList;
import java.util.Random;

public class BasicExample {
    public static void main(String[] args) {

        RecombeeClient client = new RecombeeClient("client-test", "jGGQ6ZKa8rQ1zTAyxTc0EMn55YPF7FJLUtaMLhbsGxmvwxgTwXYqmUk5xVZFw98L");
        try {
            final int NUM = 100;
            //Create some users and send them to Recombee, use Batch for faster processing
            ArrayList<Request> addUserRequests = new ArrayList<Request>();
            for (int i = 0; i < NUM; i++) addUserRequests.add(new AddUser(String.format("user-%s", i)));

            System.out.println("Send users");
            client.send(new Batch(addUserRequests));

            //Now create some items
            ArrayList<Request> addItemRequests = new ArrayList<Request>();
            for (int i = 0; i < NUM; i++) addItemRequests.add(new AddItem(String.format("item-%s", i)));

            System.out.println("Send items");
            client.send(new Batch(addItemRequests));

            // Generate some random purchases of items by users
            final double PROBABILITY_PURCHASED = 0.01;
            Random r = new Random();
            ArrayList<Request> addPurchaseRequests = new ArrayList<Request>();
            for (int i = 0; i < NUM; i++)
                for (int j = 0; j < NUM; j++)
                    if (r.nextDouble() < PROBABILITY_PURCHASED)
                        addPurchaseRequests.add(new AddPurchase(String.format("user-%s", i),String.format("item-%s", j)));

            System.out.println("Send purchases");
            client.send(new Batch(addPurchaseRequests));

            // Get 5 recommendations for user 'user-25'
            Recommendation[] recommended = client.send(new UserBasedRecommendation("user-25", 5));
            System.out.println("Recommended items:");
            for(Recommendation rec: recommended) System.out.println(rec.getId());

        } catch (ApiException e) {
            e.printStackTrace();
            //use fallback
        }
    }
}
