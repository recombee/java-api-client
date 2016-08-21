package com.recombee.api_client.api_requests;

import java.util.Map;
import com.recombee.api_client.util.HTTPMethod;

/**
* Base class for all the requests
*/
public abstract class Request {

    /**
     * Timeout for the request in milliseconds
     */
	protected long timeout;

    public long getTimeout()
    {
    	return this.timeout;
    }

    /**
     * Sets request timeout
     * @param timeout Timeout in milliseconds
     */
    public Request setTimeout(long timeout)
    {
    	this.timeout = timeout;
    	return this;
    }

    /**
     * Returns true if HTTPS must be chosen over HTTP for this request
     * @return True if HTTPS must be chosen
     */
    public boolean getEnsureHttps() {
        return false;
    }

    /**
     * @return Used HTTP method
     */
    public abstract HTTPMethod getHTTPMethod();

    /**
     * @return URI to the endpoint including path parameters
     */
    public abstract String getPath();

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    public abstract Map<String, Object> getBodyParameters();

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    public abstract Map<String, Object> getQueryParameters();
}
