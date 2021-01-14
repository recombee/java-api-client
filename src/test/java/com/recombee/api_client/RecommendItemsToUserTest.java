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

public class RecommendItemsToUserTest extends RecommendationTestCase {

    @Test
    public void testRecommendItemsToUser() throws ApiException {
        RecommendationResponse  resp;
        Object resp2;
        // it 'recommends'
        resp = this.client.send(new RecommendItemsToUser("entity_id",9));
        // it 'recommends to previously nonexisting entity with cascadeCreate'
        resp = this.client.send(new RecommendItemsToUser("nonexisting",9).setCascadeCreate(true));
        // it 'recommends with expert settings'
        resp = this.client.send(new RecommendItemsToUser("nonexisting2",9).setCascadeCreate(true).setExpertSettings(new HashMap<String, Object>(){{}}));
    }
}
