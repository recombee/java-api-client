package com.recombee.api_client;

import com.recombee.api_client.api_requests.GetUserValues;
import com.recombee.api_client.exceptions.ApiException;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.assertEquals;

public class GetUserValuesTest extends RecombeeTestCase {

    @Test
    public void testGetUserValues() throws ApiException {
        GetUserValues req;
        // it 'gets values'
        req = new GetUserValues("entity_id");
        Map<String, Object> resp = this.client.send(req);
        assertEquals (42,resp.get("int_property"));
        assertEquals ("hello",resp.get("str_property"));
    }
}
