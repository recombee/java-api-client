package com.recombee.api_client;

import com.recombee.api_client.api_requests.*;
import com.recombee.api_client.exceptions.*;
import com.recombee.api_client.util.Region;

import org.junit.Before;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

class RecombeeTestCase {
    protected RecombeeClient client;

    public RecombeeTestCase() {
        String dbId = System.getenv("DB_ID");
        String privateToken = System.getenv("PRIVATE_TOKEN");

        if (dbId == null || privateToken == null) {
            throw new IllegalStateException("Environment variables DB_ID and PRIVATE_TOKEN must be set.");
        }

        client = new RecombeeClient(dbId, privateToken).setRegion(Region.EU_WEST);
    }

    @Before
    public void setUp() throws ApiException {
        waitForDatabaseReset();

        client.send(new ResetDatabase());

        waitForDatabaseReset();

        Batch requests = new Batch(new Request[]{
                new AddItem("entity_id"),
                new AddUser("entity_id"),
                new AddSeries("entity_id"),
                new InsertToSeries("entity_id", "item", "entity_id", 1),
                new AddItemProperty("int_property", "int"),
                new AddItemProperty("str_property", "string"),
                new SetItemValues("entity_id", new HashMap<String, Object>() {
                    {
                        put("int_property", 42);
                        put("str_property", "hello");
                    }
                }),
                new AddUserProperty("int_property", "int"),
                new AddUserProperty("str_property", "string"),
                new SetUserValues("entity_id", new HashMap<String, Object>() {
                    {
                        put("int_property", 42);
                        put("str_property", "hello");
                    }
                })
        });

        client.send(requests);
    }

    private void waitForDatabaseReset() throws ApiException {
        while (true) {
            try {
                client.send(new ListItems());
                break;
            } catch (ResponseException e) {
                // Wait until DB is erased
                continue;
            }
        }
    }

    protected void waitForDataProcessing() {
        try {
            // Wait for 10 seconds
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException("Thread was interrupted during wait", e);
        }
    }

    protected Date parseDate(String dateStr) {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        try {
            return df.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
