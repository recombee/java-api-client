package com.recombee.api_client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.Response;

import org.apache.commons.codec.binary.Hex;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.text.SimpleDateFormat;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import com.recombee.api_client.api_requests.Request;
import com.recombee.api_client.exceptions.ApiException;
import com.recombee.api_client.exceptions.ApiTimeoutException;
import com.recombee.api_client.exceptions.ResponseException;
import com.recombee.api_client.util.NetworkApplicationProtocol;
import com.recombee.api_client.util.Region;
import com.recombee.api_client.util.HTTPMethod;

import com.recombee.api_client.bindings.Recommendation;
import com.recombee.api_client.api_requests.Batch;

/* Start of the generated code */
import com.recombee.api_client.bindings.*;
import com.recombee.api_client.api_requests.GetItemValues;
import com.recombee.api_client.api_requests.ListItems;
import com.recombee.api_client.api_requests.GetItemPropertyInfo;
import com.recombee.api_client.api_requests.ListItemProperties;
import com.recombee.api_client.api_requests.UpdateMoreItems;
import com.recombee.api_client.api_requests.DeleteMoreItems;
import com.recombee.api_client.api_requests.ListSeries;
import com.recombee.api_client.api_requests.ListSeriesItems;
import com.recombee.api_client.api_requests.ListGroups;
import com.recombee.api_client.api_requests.ListGroupItems;
import com.recombee.api_client.api_requests.GetUserValues;
import com.recombee.api_client.api_requests.ListUsers;
import com.recombee.api_client.api_requests.GetUserPropertyInfo;
import com.recombee.api_client.api_requests.ListUserProperties;
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
import com.recombee.api_client.api_requests.ListItemViewPortions;
import com.recombee.api_client.api_requests.ListUserViewPortions;
import com.recombee.api_client.api_requests.RecommendItemsToUser;
import com.recombee.api_client.api_requests.RecommendItemsToItem;
import com.recombee.api_client.api_requests.RecommendNextItems;
import com.recombee.api_client.api_requests.RecommendUsersToUser;
import com.recombee.api_client.api_requests.RecommendUsersToItem;
import com.recombee.api_client.api_requests.RecommendItemSegmentsToUser;
import com.recombee.api_client.api_requests.RecommendItemSegmentsToItem;
import com.recombee.api_client.api_requests.RecommendItemSegmentsToItemSegment;
import com.recombee.api_client.api_requests.SearchItems;
import com.recombee.api_client.api_requests.SearchItemSegments;
import com.recombee.api_client.api_requests.AddSearchSynonym;
import com.recombee.api_client.api_requests.ListSearchSynonyms;
import com.recombee.api_client.api_requests.ListSegmentations;
import com.recombee.api_client.api_requests.GetSegmentation;

/* End of the generated code */
/**
* Client for sending requests to Recombee and getting replies
*/
public class RecombeeClient {

    String databaseId;
    String token;

    NetworkApplicationProtocol defaultProtocol = NetworkApplicationProtocol.HTTPS;
    String baseUri = "rapi.recombee.com";
    ObjectMapper mapper;

    final int BATCH_MAX_SIZE = 10000; //Maximal number of requests within one batch request

    final String USER_AGENT = "recombee-java-api-client/4.1.0";

    private final OkHttpClient httpClient = new OkHttpClient();

    public RecombeeClient(String databaseId, String token) {
        this.databaseId = databaseId;
        this.token = token;
        this.mapper = new ObjectMapper();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        this.mapper.setDateFormat(df);
        this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (System.getenv("RAPI_URI") != null)
            this.baseUri = System.getenv("RAPI_URI");
    }

    public NetworkApplicationProtocol getDefaultProtocol() {
        return defaultProtocol;
    }

    public RecombeeClient setDefaultProtocol(NetworkApplicationProtocol defaultProtocol) {
        this.defaultProtocol = defaultProtocol;
        return this;
    }

    public RecombeeClient setBaseUri(String baseUri) {
        this.baseUri = baseUri;
        return this;
    }

    public RecombeeClient setRegion(Region region) {
        switch (region) {
            case AP_SE:
                this.baseUri = "rapi-ap-se.recombee.com";
                break;
            case CA_EAST:
                this.baseUri ="rapi-ca-east.recombee.com";
                break;
            case EU_WEST:
                this.baseUri = "rapi-eu-west.recombee.com";
                break;
            case US_WEST:
                this.baseUri = "rapi-us-west.recombee.com";
                break;
            default:
                throw new IllegalArgumentException("Unknown region given");
        }
        return this;
    }

    private String processRequestUri(Request request) {
        String uri = "/" + this.databaseId + request.getPath();
        uri = appendQueryParameters(uri, request);
        return uri;
    }
    /* Start of the generated code */
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

    public UpdateMoreItemsResponse send(UpdateMoreItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, UpdateMoreItemsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public DeleteMoreItemsResponse send(DeleteMoreItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, DeleteMoreItemsResponse.class);
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

    public PropertyInfo send(GetUserPropertyInfo request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, PropertyInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public PropertyInfo[] send(ListUserProperties request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, PropertyInfo[].class);
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

    public ViewPortion[] send(ListItemViewPortions request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, ViewPortion[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public ViewPortion[] send(ListUserViewPortions request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, ViewPortion[].class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendItemsToUser request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendItemsToItem request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendNextItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendUsersToUser request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendUsersToItem request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendItemSegmentsToUser request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendItemSegmentsToItem request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public RecommendationResponse send(RecommendItemSegmentsToItemSegment request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, RecommendationResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public SearchResponse send(SearchItems request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, SearchResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public SearchResponse send(SearchItemSegments request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, SearchResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public SearchSynonym send(AddSearchSynonym request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, SearchSynonym.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public ListSearchSynonymsResponse send(ListSearchSynonyms request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, ListSearchSynonymsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public ListSegmentationsResponse send(ListSegmentations request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, ListSegmentationsResponse.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    public Segmentation send(GetSegmentation request) throws ApiException {
        String responseStr = sendRequest(request);
        try {
            return this.mapper.readValue(responseStr, Segmentation.class);
        } catch (IOException e) {
            e.printStackTrace();
         }
         return null;
    }

    /* End of the generated code */

    public BatchResponse[] send(Batch batchRequest) throws ApiException {

        if(batchRequest.getRequests().size() > this.BATCH_MAX_SIZE) {
            return sendMultipartBatchRequest(batchRequest);
        }

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
                    if (request instanceof ListItems)
                    {
                        boolean returnProperties = ((ListItems) request).getReturnProperties();
                        if(returnProperties)
                        {
                            ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                            Item[] ar = new Item[array.size()];
                            for(int j=0;j<ar.length;j++) ar[j] = new Item((String)array.get(j).get("itemId"), array.get(j));
                            parsedResponse = ar;
                        }
                        else
                        {
                            ArrayList<String> array = (ArrayList<String>) parsedResponse;
                            Item[] ar = new Item[array.size()];
                            for(int j=0;j<ar.length;j++) ar[j] = new Item(array.get(j));
                            parsedResponse = ar;
                        }
                    }
                    else if (request instanceof ListUsers)
                    {
                        boolean returnProperties = ((ListUsers) request).getReturnProperties();
                        if(returnProperties)
                        {
                            ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                            User[] ar = new User[array.size()];
                            for(int j=0;j<ar.length;j++) ar[j] = new User((String)array.get(j).get("userId"), array.get(j));
                            parsedResponse = ar;
                        }
                        else
                        {
                            ArrayList<String> array = (ArrayList<String>) parsedResponse;
                            User[] ar = new User[array.size()];
                            for(int j=0;j<ar.length;j++) ar[j] = new User(array.get(j));
                            parsedResponse = ar;
                        }
                    }
                    else if (request instanceof AddSearchSynonym)
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, SearchSynonym.class);
                    }
                    else if (request instanceof ListSearchSynonyms)
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, ListSearchSynonymsResponse.class);
                    }
                    else if ((request instanceof RecommendItemsToUser) ||
                            (request instanceof RecommendUsersToUser) ||
                            (request instanceof RecommendItemsToItem) ||
                            (request instanceof RecommendUsersToItem) ||
                            (request instanceof RecommendNextItems) ||
                            (request instanceof RecommendItemSegmentsToUser) ||
                            (request instanceof RecommendItemSegmentsToItem) ||
                            (request instanceof RecommendItemSegmentsToItemSegment) ||
                            (request instanceof SearchItemSegments))
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, RecommendationResponse.class);
                    }
                    else if (request instanceof SearchItems)
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, SearchResponse.class);
                    }
                    else if (request instanceof UpdateMoreItems)
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, UpdateMoreItemsResponse.class);
                    }
                    else if (request instanceof DeleteMoreItems)
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, DeleteMoreItemsResponse.class);
                    }
                    else if (request instanceof ListSegmentations)
                    {
                        parsedResponse = mapper.convertValue(parsedResponse, ListSegmentations.class);
                    }
                    /* Start of the generated code */
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

                    else if (request instanceof GetUserPropertyInfo)
                    {
                        Map<String, Object> obj = (Map<String, Object>) parsedResponse;
                        parsedResponse = new PropertyInfo(obj);
                    }

                    else if (request instanceof ListUserProperties)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        PropertyInfo[] ar = new PropertyInfo[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new PropertyInfo(array.get(j));
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

                    else if (request instanceof ListItemViewPortions)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        ViewPortion[] ar = new ViewPortion[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new ViewPortion(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof ListUserViewPortions)
                    {
                        ArrayList<Map<String, Object>> array = (ArrayList<Map<String, Object>>) parsedResponse;
                        ViewPortion[] ar = new ViewPortion[array.size()];
                        for(int j=0;j<ar.length;j++) ar[j] = new ViewPortion(array.get(j));
                        parsedResponse = ar;
                    }

                    else if (request instanceof GetSegmentation)
                    {
                        Map<String, Object> obj = (Map<String, Object>) parsedResponse;
                        parsedResponse = new Segmentation(obj);
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



    private BatchResponse[] sendMultipartBatchRequest(Batch batchRequest) throws ApiException {

        List<List<Request>> requestChunks = getRequestsChunks(batchRequest);
        ArrayList<BatchResponse[]> responses = new ArrayList<BatchResponse[]>();

        for(List<Request> rqs: requestChunks)
            responses.add(send(new Batch(rqs)));

        return concatenateResponses(responses);
    }

    private List<List<Request>> getRequestsChunks(Batch batchRequest) {

        ArrayList<List<Request>> result = new ArrayList<List<Request>>();
        List<Request> requests = batchRequest.getRequests();
        int fullparts = requests.size() / this.BATCH_MAX_SIZE;

        for(int i=0;i<fullparts;i++)
            result.add(requests.subList(i * this.BATCH_MAX_SIZE, (i+1) * this.BATCH_MAX_SIZE));

        if(fullparts * this.BATCH_MAX_SIZE < requests.size())
            result.add(requests.subList(fullparts * this.BATCH_MAX_SIZE, requests.size()));

        return result;
    }

    private BatchResponse[] concatenateResponses(ArrayList<BatchResponse[]> responses)
    {
        int size = 0, i = 0;

        for(BatchResponse[] rsps: responses) {
            size += rsps.length;
        }

        BatchResponse[] result = new BatchResponse[size];

        for(BatchResponse[] rsps: responses) {
            for(BatchResponse rsp: rsps)
                result[i++] = rsp;
        }
        return result;
    }    /* End of the generated code */

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


    public Map<String, Object> send(GetUserValues request) throws ApiException {
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

    public Item[] send(ListItems request) throws ApiException {
        String responseStr = sendRequest(request);

        try {
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true); // Check exact match
            return this.mapper.readValue(responseStr, Item[].class);
        } catch (IOException e) {
            //might have failed because it returned also the item properties
            TypeReference<HashMap<String,Object>[]> typeRef 
                    = new TypeReference<HashMap<String,Object>[]>() {};
            try {
                Map<String, Object>[] valsArray = this.mapper.readValue(responseStr, typeRef);
                Item [] recomms = new Item[valsArray.length];
                for(int i=0;i<valsArray.length;i++)
                    recomms[i] = new Item((String)valsArray[i].get("itemId"), valsArray[i]);
                return recomms;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        finally {
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return null;
    }


    public User[] send(ListUsers request) throws ApiException {
        String responseStr = sendRequest(request);

        try {
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true); // Check exact match
            return this.mapper.readValue(responseStr, User[].class);
        } catch (IOException e) {
            //might have failed because it returned also the user properties
            TypeReference<HashMap<String,Object>[]> typeRef 
                    = new TypeReference<HashMap<String,Object>[]>() {};
            try {
                Map<String, Object>[] valsArray = this.mapper.readValue(responseStr, typeRef);
                User [] recomms = new User[valsArray.length];
                for(int i=0;i<valsArray.length;i++)
                    recomms[i] = new User((String)valsArray[i].get("userId"), valsArray[i]);
                return recomms;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        finally {
            this.mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        return null;
    }
    public String send(Request request) throws ApiException {
        return sendRequest(request);
    }

    private String sendRequest(Request request) throws ApiException {
        String signedUri = signUrl(processRequestUri(request));
        String protocolStr = request.getEnsureHttps() ? "https" : this.defaultProtocol.name().toLowerCase();
        String uri = protocolStr + "://" + this.baseUri + signedUri;

        OkHttpClient tempClient = this.httpClient.newBuilder()
                .connectTimeout(request.getTimeout(), TimeUnit.MILLISECONDS)
                .readTimeout(request.getTimeout(), TimeUnit.MILLISECONDS)
                .writeTimeout(request.getTimeout(), TimeUnit.MILLISECONDS)
                .build();


        okhttp3.Request.Builder httpRequestBuilder = new okhttp3.Request.Builder()
                .url(uri)
                .addHeader("User-Agent", this.USER_AGENT);


        if (request.getHTTPMethod() != HTTPMethod.GET) {
            httpRequestBuilder.addHeader("Content-Type", "application/json; charset=utf-8");
            RequestBody body = getBody(request);
            if (body != null){
                switch (request.getHTTPMethod()) {
                    case POST:
                        httpRequestBuilder.post(body);
                        break;
                    case PUT:
                        httpRequestBuilder.put(body);
                        break;
                    case DELETE:
                        httpRequestBuilder.delete(body);
                        break;
                }
            }
        }

        try {
            Response response = tempClient.newCall(httpRequestBuilder.build()).execute();
            checkErrors(response, request);
            return response.body().string();
        }
        catch (InterruptedIOException e) {
            throw new ApiTimeoutException(request);
        }
        catch (IOException e) {
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

    private RequestBody getBody(Request req) {
        try {
            String json = this.mapper.writeValueAsString(req.getBodyParameters());
            final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
            return RequestBody.create(JSON, json);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    private void checkErrors(Response response, Request request) throws ResponseException {
        if(response.code() == 200 || response.code() == 201) return;
        try {
            throw new ResponseException(request, response.code(), response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
            throw new ResponseException(request, response.code(), "Failed to read the error from response");
        }
    }
}
