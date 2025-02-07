package com.recombee.api_client.exceptions;

import com.recombee.api_client.api_requests.Request;

/**
 * Exception thrown when a request did not succeed (did not return 200 or 201)
 */
public class ResponseException extends  ApiException {

    /**
     * Request which failed
     */
    Request request;
    /**
     * Obtained HTTP status code
     */
    int statusCode;

    public ResponseException(Request request, int statusCode, String message) {
        super(message);
        this.request = request;
        this.statusCode = statusCode;
    }

    public Request getRequest() {
        return request;
    }

    public int getStatusCode() {
        return statusCode;
    }
}
