package com.recombee.api_client.api_requests;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

import com.recombee.api_client.util.HTTPMethod;

/**
 * In many cases, it may be desirable to execute multiple requests at once. For example, when synchronizing the catalog of items in periodical manner, you would have to execute a sequence of thousands of separate POST requests, which is very ineffective and may take a very long time to complete. Most notably, network latencies can make execution of such a sequence very slow and even if executed in multiple parallel threads, there will still be unreasonable overhead caused by the HTTP(s). To avoid the problems mentioned, batch processing may be used, encapsulating a sequence of requests into a single HTTP request.
 * Batch processing allows you to submit arbitrary sequence of requests in form of JSON array. Any type of request from the above documentation may be used in the batch, and the batch may combine different types of requests arbitrarily as well.
 * Note that:
 * - executing the requests in a batch is equivalent as if they were executed one-by-one individually; there are, however, many optimizations to make batch execution as fast as possible,
 * - the status code of the batch request itself is 200 even if the individual requests result in error – you have to inspect the code values in the resulting array,
 * - if the status code of the whole batch is not 200, then there is an error in the batch request itself; in such a case, the error message returned should help you to resolve the problem,
 * - currently, batch size is limited to **10,000** requests; if you wish to execute even larger number of requests, please split the batch into multiple parts.
 */
public class Batch extends Request {

    /**
     * Requests contained in the batch
     */
    protected List<Request> requests;
    protected boolean distinctRecomms;

    /**
     * Construct the request
     * @param requests Requests which should be processed in a single batch request
     */
    public Batch (List<Request> requests) {
        initialize(requests);
    }

    /**
     * Construct the request
     * @param requests Requests which should be processed in a single batch request
     */
    public Batch(Request[] requests)
    {
        initialize(Arrays.<Request>asList(requests));
    }

    private void initialize(List<Request> requests)
    {
        this.requests = requests;
        this.distinctRecomms = false;
        this.timeout = 0;
        for(Request r: this.requests)
            this.timeout += r.getTimeout();
    }

    public List<Request> getRequests() {
        return this.requests;
    }

    /**
     * @param distinctRecomms Makes all the recommended items for a certain user distinct among multiple recommendation requests in the batch
     */
    public Batch setDistinctRecomms(boolean distinctRecomms) {
         this.distinctRecomms = distinctRecomms;
         return this;
    }

    public boolean getDistinctRecomms() {
         return this.distinctRecomms;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.POST;
    }

    /**
     * Returns true if HTTPS must be chosen over HTTP for this request
     * @return True if HTTPS must be chosen
     */
    @Override
    public boolean getEnsureHttps() {
        return true;
    }

    /**
     * @return URI to the endpoint
     */
    @Override
    public String getPath() {
        return "/batch/";
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        return new HashMap<String, Object>();
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {

        ArrayList<Map<String, Object>> requestMaps = new ArrayList<Map<String, Object>>();
        for(Request r: this.requests)
            requestMaps.add(requestToBatchMap(r));

        HashMap<String, Object> result = new HashMap<String, Object>();
        result.put("requests", requestMaps);
        result.put("distinctRecomms", this.distinctRecomms);
        return result;
    }

    protected Map<String, Object> requestToBatchMap(Request req)
    {
        HashMap<String, Object> bm = new HashMap<String, Object>();
        bm.put("path", req.getPath());
        bm.put("method", req.getHTTPMethod().name());
        Map<String, Object> params = req.getQueryParameters();
        params.putAll(req.getBodyParameters());
        if (params.size() > 0) bm.put("params", params);
        return bm;
    }
}