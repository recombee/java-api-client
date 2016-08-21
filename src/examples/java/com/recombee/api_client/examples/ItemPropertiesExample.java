package com.recombee.api_client.examples;

import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.exceptions.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ItemPropertiesExample {
    public static void main(String[] args) {

        RecombeeClient client = new RecombeeClient("client-test", "jGGQ6ZKa8rQ1zTAyxTc0EMn55YPF7FJLUtaMLhbsGxmvwxgTwXYqmUk5xVZFw98L");

        try {
            client.send(new ResetDatabase()); //Clear everything from the database

            /*
            We will use computers as items in this example
            Computers have three properties
              - price (floating point number)
              - number of processor cores (integer number)
              - description (string)
            */

            client.send(new AddItemProperty("price", "double"));
            client.send(new AddItemProperty("num-cores", "int"));
            client.send(new AddItemProperty("description", "string"));

            // Prepare requests for setting a catalog of computers
            final ArrayList<Request> requests = new ArrayList<Request>();
            final int NUM = 100;
            final Random rand = new Random();

            for(int i=0; i<NUM; i++)
            {
                final SetItemValues req = new SetItemValues(
                    String.format("computer-%s",i), //itemId
                    //values:
                    new HashMap<String, Object>() {{
                        put("price", 600.0 + 400*rand.nextDouble());
                        put("num-cores", 1 + rand.nextInt(7));
                        put("description", "Great computer");
                        put("!cascadeCreate", true); // Use !cascadeCreate for creating item
                                                     // with given itemId, if it doesn't exist
                    }}
                );
                requests.add(req);
            }
            client.send(new Batch(requests)); // Send catalog to the recommender system

            // Generate some random purchases of items by users
            final double PROBABILITY_PURCHASED = 0.02;
            ArrayList<Request> addPurchaseRequests = new ArrayList<Request>();
            for (int i = 0; i < NUM; i++)
                for (int j = 0; j < NUM; j++)
                    if (rand.nextDouble() < PROBABILITY_PURCHASED) {
                        AddPurchase req = new AddPurchase(String.format("user-%s", i),String.format("computer-%s", j))
                                                .setCascadeCreate(true); //use cascadeCreate to create the users
                        addPurchaseRequests.add(req);
                    }
            client.send(new Batch(addPurchaseRequests)); // Send purchases to the recommender system


            // Get 5 recommendations for user-42, who is currently viewing computer-6
            Recommendation[] recommended = client.send(new ItemBasedRecommendation("computer-6", 5)
                                                            .setTargetUserId("user-42"));
            System.out.println("Recommended items:");
            for(Recommendation rec: recommended) System.out.println(rec.getId());


            // Get 5 recommendations for user-42, but recommend only computers that have at least 3 cores
            recommended = client.send(new ItemBasedRecommendation("computer-6", 5).setTargetUserId("user-42")
                                            .setFilter(" 'num-cores'>=3 "));
            System.out.println("Recommended items with at least 3 processor cores:");
            for(Recommendation rec: recommended) System.out.println(rec.getId());

            // Get 5 recommendations for user-42, but recommend only items that are more expensive then currently viewed item (up-sell)
            recommended = client.send(new ItemBasedRecommendation("computer-6", 5).setTargetUserId("user-42")
                                            .setFilter(" 'price' > context_item[\"price\"] "));

            System.out.println("Recommended up-sell items:");
            for(Recommendation rec: recommended) System.out.println(rec.getId());

        } catch (ApiException e) {
            e.printStackTrace();
            //Use fallback
        }
    }
}
