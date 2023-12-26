package com.recombee.api_client.bindings;

import com.recombee.api_client.exceptions.ApiException;

public class BatchResponse {
    /**
    * Resulting HTTP Status Code for one request in batch
    */
    int statusCode;
    /**
    * Response to one request in batch. The type of the response corresponds to the request - it may be for example Recommendation[], DetailView[], PropertyInfo or Item[].
    */
    Object response;

    public BatchResponse(int statusCode, Object response)
    {
        this.statusCode = statusCode;
        this.response = response;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public boolean isSuccessful()
    {
        return ((this.statusCode ==200)||(this.statusCode ==201));
    }

    /**
    * @return Returns the response in case of successful request, or throws corresponding exception
    */
    public Object getResponse() throws ApiException {
        if(!isSuccessful()) throw (ApiException) response;
        return this.response;
    }
}
