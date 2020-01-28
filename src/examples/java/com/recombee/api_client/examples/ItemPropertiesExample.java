import com.recombee.api_client.RecombeeClient;
import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.bindings.RecommendationResponse;
import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.bindings.SearchResponse;
import com.recombee.api_client.exceptions.ApiException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ItemPropertiesExample {
    public static void main(String[] args) {

        RecombeeClient client = new RecombeeClient("--my-database-id--", "--db-private-token--");

        try {
            client.send(new ResetDatabase()); //Clear everything from the database

            /*
            We will use computers as items in this example
            Computers have four properties
              - price (floating point number)
              - number of processor cores (integer number)
              - description (string)
              - image (url of computer's photo)
            */

            client.send(new AddItemProperty("price", "double"));
            client.send(new AddItemProperty("num-cores", "int"));
            client.send(new AddItemProperty("description", "string"));
            client.send(new AddItemProperty("image", "image"));

            // Prepare requests for setting a catalog of computers
            final ArrayList<Request> requests = new ArrayList<Request>();
            final int NUM = 100;
            final Random rand = new Random();

            for(int i=0; i<NUM; i++)
            {
                final String itemId = String.format("computer-%s",i);
                final SetItemValues req = new SetItemValues(
                        itemId,
                        //values:
                        new HashMap<String, Object>() {{
                            put("price", 600.0 + 400*rand.nextDouble());
                            put("num-cores", 1 + rand.nextInt(7));
                            put("description", "Great computer");
                            put("image", String.format("http://examplesite.com/products/%s.jpg", itemId));
                        }}
                ).setCascadeCreate(true);  // Use cascadeCreate for creating item
                // with given itemId, if it doesn't exist;
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
            // Recommend only computers that have at least 3 cores
            RecommendationResponse recommendationResponse = client.send(
                    new RecommendItemsToItem("computer-6", "user-42", 5)
                            .setFilter(" 'num-cores'>=3 "));
            System.out.println("Recommended items with at least 3 processor cores:");
            for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());

            // Recommend only items that are more expensive then currently viewed item (up-sell)
            recommendationResponse = client.send(new RecommendItemsToItem("computer-6", "user-42", 5)
                    .setFilter(" 'price' > context_item[\"price\"] "));

            System.out.println("Recommended up-sell items:");
            for(Recommendation rec: recommendationResponse) System.out.println(rec.getId());


            // Filters, boosters and other settings can be set also in the Admin UI (admin.recombee.com)
            // when scenario is specified
            recommendationResponse = client.send(
                    new RecommendItemsToItem("computer-6", "user-42", 5).setScenario("product_detail")
            );

            // Perform personalized full-text search with a user's search query (e.g. "computers")
            SearchResponse searchResponse = client.send(
                    new SearchItems("user-42", "computers", 5)
            );
            System.out.println("Search matches:");
            for(Recommendation rec: searchResponse) System.out.println(rec.getId());

        } catch (ApiException e) {
            e.printStackTrace();
            //Use fallback
        }
    }
}
