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

public class RecommendUsersToUserBatchTest extends RecommendationTestCase {

    @Test
    public void testRecommendUsersToUser() throws ApiException {
        Object resp2;
        Request[] requests = new Request[] {
            new RecommendUsersToUser("entity_id",9),
            new RecommendUsersToUser("nonexisting",9).setCascadeCreate(true),
            new RecommendUsersToUser("nonexisting2",9).setCascadeCreate(true).setExpertSettings(new HashMap<String, Object>(){{}}),
            new RecommendUsersToUser("nonexisting2",9).setCascadeCreate(true).setReqlExpressions(new HashMap<String, String>(){{put("boolean","true");put("number","if ('answer' > 0) then 1 else 2");put("string","\"test\"");}})
        };

        BatchResponse[] responses = this.client.send(new Batch(requests));
        assertEquals(200,responses[0].getStatusCode());
        assertEquals(200,responses[1].getStatusCode());
        assertEquals(200,responses[2].getStatusCode());
        assertEquals(200,responses[3].getStatusCode());
    }
}
