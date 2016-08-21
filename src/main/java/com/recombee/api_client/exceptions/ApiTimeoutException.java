package com.recombee.api_client.exceptions;

import com.recombee.api_client.api_requests.Request;

/**
 * Exception thrown when a request is not processed within the timeout
 */
public class ApiTimeoutException extends  ApiException {

    /**
     * Request that timed out
     */
    Request request;

    public ApiTimeoutException(Request request) {
        super(String.format("ApiTimeout: client did not get response within %s ms" , request.getTimeout()));
        this.request = request;
    }

    public Request getRequest() {
        return request;
    }
}
