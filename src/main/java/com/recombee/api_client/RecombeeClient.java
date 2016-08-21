package com.recombee.api_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;


import org.apache.commons.codec.binary.Hex;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.api_requests.Request;
import com.recombee.api_client.exceptions.ApiException;
import com.recombee.api_client.exceptions.ApiTimeoutException;
import com.recombee.api_client.exceptions.ResponseException;
import com.recombee.api_client.util.NetworkApplicationProtocol;

import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.api_requests.Batch;

/* Start of the generated code */
import com.recombee.api_client.bindings.*;
import com.recombee.api_client.api_requests.GetItemValues;
import com.recombee.api_client.api_requests.ListItems;
import com.recombee.api_client.api_requests.GetItemPropertyInfo;
import com.recombee.api_client.api_requests.ListItemProperties;
import com.recombee.api_client.api_requests.ListSeries;
import com.recombee.api_client.api_requests.ListSeriesItems;
import com.recombee.api_client.api_requests.ListGroups;
import com.recombee.api_client.api_requests.ListGroupItems;
import com.recombee.api_client.api_requests.ListUsers;
import com.recombee.api_client.api_requests.ListItemDetailViews;
import com.recombee.api_client.api_requests.ListUserDetailViews;
import com.recombee.api_client.api_requests.ListItemPurchases;
import com.recombee.api_client.api_requests.ListUserPurchases;
import com.recombee.api_client.api_requests.ListItemRatings;
import com.recombee.api_client.api_requests.ListUserRatings;
import com.recombee.api_client.api_requests.ListItemCartAdditions;
import com.recombee.api_client.api_requests.ListUserCartAdditions;
import com.recombee.api_client.api_requests.ListItemBookmarks;
import com.recombee.api_client.api_requests.ListUserBookmarks;
import com.recombee.api_client.api_requests.UserBasedRecommendation;
import com.recombee.api_client.api_requests.ItemBasedRecommendation;

/* End of the generated code */
/**
* Client for sending requests to Recombee and getting replies
*/
public class RecombeeClient {

    String databaseId;
    String token;

    NetworkApplicationProtocol defaultProtocol = NetworkApplicationProtocol.HTTP;
    String baseUri = "rapi.recombee.com";
    ObjectMapper mapper;

    public RecombeeClient(String databaseId, String token) {
        this.databaseId = databaseId;
        this.token = token;
        this.mapper = new ObjectMapper();

        if (System.getenv("RAPI_URI") != null)
            this.baseUri = System.getenv("RAPI_URI");
    }

    public NetworkApplicationProtocol getDefaultProtocol() {
        return defaultProtocol;
    }

    public void setDefaultProtocol(NetworkApplicationProtocol defaultProtocol) {
        this.defaultProtocol = defaultProtocol;
    }
    /* Start of the generated code */
    public Item[] send(ListItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Item[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public PropertyInfo send(GetItemPropertyInfo request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, PropertyInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public PropertyInfo[] send(ListItemProperties request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, PropertyInfo[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Series[] send(ListSeries request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Series[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public SeriesItem[] send(ListSeriesItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, SeriesItem[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Group[] send(ListGroups request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Group[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public GroupItem[] send(ListGroupItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, GroupItem[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public User[] send(ListUsers request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, User[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public DetailView[] send(ListItemDetailViews request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, DetailView[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public DetailView[] send(ListUserDetailViews request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, DetailView[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Purchase[] send(ListItemPurchases request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Purchase[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Purchase[] send(ListUserPurchases request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Purchase[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Rating[] send(ListItemRatings request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Rating[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Rating[] send(ListUserRatings request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Rating[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public CartAddition[] send(ListItemCartAdditions request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, CartAddition[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public CartAddition[] send(ListUserCartAdditions request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, CartAddition[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Bookmark[] send(ListItemBookmarks request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Bookmark[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Bookmark[] send(ListUserBookmarks request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Bookmark[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    /* End of the generated code */

    public BatchResponse[] send(Batch batchRequest) throws ApiException {
        String responseStr = sendRequest(batchRequest);

        try {
            Object[] responses = this.mapper.readValue(responseStr, Object[].class);
            BatchResponse[] result = new BatchResponse[responses.length];
            for(int i=0;i<responses.length;i++)
            {
                Map<String, Object> response = (Map<String, Object>) responses[i];
                int status = (Integer) response.get("code");
                Object parsedResponse = response.get("json");
                Request request = batchRequest.getRequests().get(i);

                if(status!=200 && status!=201)
                {
                    Map<String, Object> exceptionMap = (Map<String,Object>) parsedResponse;
                    parsedResponse = new ResponseException(request, status, (String)exceptionMap.get("error"));
                }
                else
                {
                    if ((request instanceof ItemBasedRecommendation) || (request instanceof UserBasedRecommendation))
                    {
                        boolean returnProperties = false;
                        if (request instanceof ItemBasedRecommendation) returnProperties = ((ItemBasedRecommendation) request).getReturnProperties();
                        if (request instanceof UserBasedRecommendation) returnProperties = ((UserBasedRecommendation) request).getReturnProperties();

                        if(returnProperties)
                        {
                            ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                            Recommendation[] ar = new Recommendation[array.size()];
                            for(int j=0;j<ar.length;j++) ar[j] = new Recommendation((String)array.get(j).get("itemId"), array.get(j));
                            parsedResponse = ar;
                        }
                        else
                        {
                            ArrayList<String> array = (ArrayList<String>) parsedResponse;
                            Recommendation[] ar = new Recommendation[array.size()];
                            for(int j=0;j<ar.length;j++) ar[j] = new Recommendation(array.get(j));
                            parsedResponse = ar;
                        }
                    }
                    /* Start of the generated code */
                    else if (request instanceof ListItems)
                    {
                        ArrayList<String> array = (ArrayList<String>) parsedResponse;
                        Item[] ar = new Item[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Item(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof GetItemPropertyInfo)
                    {
                        Map<String, Object> obj = (Map<String, Object>) parsedResponse;
                        parsedResponse = new PropertyInfo(obj);
                    }

                    else if (request instanceof ListItemProperties)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        PropertyInfo[] ar = new PropertyInfo[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new PropertyInfo(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListSeries)
                    {
                        ArrayList<String> array = (ArrayList<String>) parsedResponse;
                        Series[] ar = new Series[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Series(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListSeriesItems)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        SeriesItem[] ar = new SeriesItem[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new SeriesItem(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListGroups)
                    {
                        ArrayList<String> array = (ArrayList<String>) parsedResponse;
                        Group[] ar = new Group[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Group(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListGroupItems)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        GroupItem[] ar = new GroupItem[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new GroupItem(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUsers)
                    {
                        ArrayList<String> array = (ArrayList<String>) parsedResponse;
                        User[] ar = new User[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new User(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListItemDetailViews)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        DetailView[] ar = new DetailView[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new DetailView(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUserDetailViews)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        DetailView[] ar = new DetailView[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new DetailView(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListItemPurchases)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        Purchase[] ar = new Purchase[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Purchase(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUserPurchases)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        Purchase[] ar = new Purchase[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Purchase(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListItemRatings)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        Rating[] ar = new Rating[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Rating(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUserRatings)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        Rating[] ar = new Rating[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Rating(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListItemCartAdditions)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        CartAddition[] ar = new CartAddition[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new CartAddition(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUserCartAdditions)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        CartAddition[] ar = new CartAddition[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new CartAddition(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListItemBookmarks)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        Bookmark[] ar = new Bookmark[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Bookmark(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUserBookmarks)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        Bookmark[] ar = new Bookmark[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new Bookmark(array.get(j));
                        parsedResponse = ar;
                    }
                /* End of the generated code */
                }

                result[i] = new BatchResponse(status, parsedResponse);
            }
            return result;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /* End of the generated code */

    public Map<String, Object> send(GetItemValues request) throws ApiException {
        String responseStr = sendRequest(request);

        TypeReference<HashMap<String,Object>> typeRef 
                = new TypeReference<HashMap<String,Object>>() {};
        try {
            return this.mapper.readValue(responseStr, typeRef);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Recommendation[] send(UserBasedRecommendation request) throws ApiException {
        return sendRecomm(request);
    }

    public Recommendation[] send(ItemBasedRecommendation request) throws ApiException {
        return sendRecomm(request);
    }

    protected Recommendation[] sendRecomm(Request request) throws ApiException {
        String responseStr = sendRequest(request);

        try {
            return this.mapper.readValue(responseStr, Recommendation[].class);
        } catch (IOException e) {
            //might have failed because it returned also the item properties
            TypeReference<HashMap<String,Object>[]> typeRef 
                    = new TypeReference<HashMap<String,Object>[]>() {};
            try {
                Map<String, Object>[] valsArray = this.mapper.readValue(responseStr, typeRef);
                Recommendation [] recomms = new Recommendation[valsArray.length];
                for(int i=0;i<valsArray.length;i++)
                    recomms[i] = new Recommendation((String)valsArray[i].get("itemId"), valsArray[i]);
                return recomms;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
         }
         return null;
    }


    public String send(Request request) throws ApiException {
        return sendRequest(request);
    }

    protected String sendRequest(Request request) throws ApiException {
        String signedUri = signUrl(processRequestUri(request));
        String protocolStr = request.getEnsureHttps() ? "https" : this.defaultProtocol.name().toLowerCase();
        String uri = protocolStr + "://" + this.baseUri + "/" + signedUri;
        Unirest.setTimeouts(request.getTimeout(), request.getTimeout());

        HttpRequest httpRequest = null;
        switch (request.getHTTPMethod()) {
            case GET:
                httpRequest = get(uri);
                break;
            case POST:
                httpRequest = post(uri, request);
                break;
            case PUT:
                httpRequest = put(uri);
                break;
            case DELETE:
                httpRequest = delete(uri);
                break;
        }

        try {
            HttpResponse<String> response = httpRequest.asString();
            checkErrors(response, request);
            return response.getBody();
        } catch (UnirestException e) {
            if(e.getCause() != null && (e.getCause() instanceof org.apache.http.conn.ConnectTimeoutException
                    ||e.getCause() instanceof java.net.SocketTimeoutException)) {
                throw new ApiTimeoutException(request);
            }
            e.printStackTrace();
        }

        return null;
    }

    private String signUrl(String url) {
        url = url + (url.contains("?") ? "&" : "?") + "hmac_timestamp=" + System.currentTimeMillis() / 1000;

        try {
            Mac mac = Mac.getInstance("HmacSHA1");
            SecretKeySpec secret = new SecretKeySpec(this.token.getBytes(), "HmacSHA1");
            mac.init(secret);
            byte[] rawHmac = mac.doFinal(url.getBytes());
            String sign = Hex.encodeHexString(rawHmac);
            return url + "&hmac_sign=" + sign;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
        return null;
    }

    private String processRequestUri(Request request) {
        String uri = "/" + this.databaseId + request.getPath();
        uri = appendQueryParameters(uri, request);
        return uri;
    }

    private String appendQueryParameters(String uri, Request request) {
        for (Map.Entry<String, Object> pair : request.getQueryParameters().entrySet()) {
            uri += uri.contains("?") ? "&" : "?";
            uri += pair.getKey() + "=" + formatQueryParameterValue(pair.getValue());
        }
        return uri;
    }

    private String formatQueryParameterValue(Object val) {
        try {
            return URLEncoder.encode(val.toString(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    private HttpRequest get(String url) {
        return Unirest.get(url);
    }

    private HttpRequest put(String url) {
        return Unirest.put(url);
    }

    private HttpRequest delete(String url) {
        return Unirest.delete(url);
    }

    private HttpRequest post(String url, Request req) {
        try {
            String json = new ObjectMapper().writeValueAsString(req.getBodyParameters());
            return Unirest.post(url).header("Content-Type", "application/json").
                    body(json.getBytes()).getHttpRequest();
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void checkErrors(HttpResponse<String> response, Request request) throws ResponseException {
        if(response.getStatus() == 200 || response.getStatus() == 201) return;
        throw new ResponseException(request, response.getStatus(), response.getBody());

    }
}