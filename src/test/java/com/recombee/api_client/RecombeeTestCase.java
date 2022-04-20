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
        client = new RecombeeClient("client-test", "jGGQ6ZKa8rQ1zTAyxTc0EMn55YPF7FJLUtaMLhbsGxmvwxgTwXYqmUk5xVZFw98L").setRegion(Region.EU_WEST);
    }

    @Before
    public void setUp () throws ApiException {
        client.send(new ResetDatabase());

        while(true)
        {
            try {
                client.send(new ListItems());
                break;
            } catch(ResponseException e) {
                // Wait until DB is erased
                continue;
            }
        }

        Batch requests = new Batch(new Request[]{
                new AddItem("entity_id"),
                new AddUser("entity_id"),
                new AddSeries("entity_id"),
                new AddGroup("entity_id"),
                new InsertToGroup("entity_id", "item", "entity_id"),
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