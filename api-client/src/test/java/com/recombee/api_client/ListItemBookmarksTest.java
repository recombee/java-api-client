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

public class ListItemBookmarksTest extends InteractionsTestCase {

    @Test
    public void testListItemBookmarks() throws ApiException {
        Bookmark [] resp;
        Object resp2;
        // it 'lists interactions'
        waitForDataProcessing();
        resp = this.client.send(new ListItemBookmarks("item"));
        assertEquals(1, resp.length);
        assertEquals ("item",resp[0].getItemId());
        assertEquals ("user",resp[0].getUserId());
    }
}
