package com.recombee.api_client.exceptions;

/**
 * Base class for exceptions that occur because of errors in requests reported by API or because of a timeout
 */
public class ApiException extends Exception {
	
    public ApiException(String message) {
        super(message);
    }
}
