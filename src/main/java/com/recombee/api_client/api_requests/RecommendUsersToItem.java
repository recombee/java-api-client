package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.util.HTTPMethod;

/**
 * This feature is currently in beta.
 * Recommend users that are likely to be interested in a given item.
 * It is also possible to use POST HTTP method (for example in case of very long ReQL filter) - query parameters then become body parameters.
 */
public class RecommendUsersToItem extends Request {

    /**
     * ID of the item for which the recommendations are to be generated.
     */
    protected String itemId;
    /**
     * Number of items to be recommended (N for the top-N recommendation).
     */
    protected Long count;
    /**
     * Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended items based on the values of their attributes.
     */
    protected String filter;
    /**
     * Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some items based on the values of their attributes.
     */
    protected String booster;
    /**
     * If item of given *itemId* doesn't exist in the database, it creates the missing item.
     */
    protected Boolean cascadeCreate;
    /**
     * Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing". You can see each scenario in the UI separately, so you can check how well each application performs. The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * With `returnProperties=true`, property values of the recommended users are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying the recommended users. 
     * Example response:
     * ```
     *   {
     *     "recommId": "9eeebc318508302529e3241f4570834d",
     *     "recomms":
     *       [
     *         {
     *           "id": "user-17",
     *           "values": {
     *             "country": "US",
     *             "sex": "F"
     *           }
     *         },
     *         {
     *           "id": "user-2",
     *           "values": {
     *             "country": "CAN",
     *             "sex": "M"
     *           }
     *         }
     *       ]
     *   }
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   {
     *     "recommId": "d4c826635efc3e01a83470008c5697f1",
     *     "recomms":
     *       [
     *         {
     *           "id": "user-17",
     *           "values": {
     *             "country": "US"
     *           }
     *         },
     *         {
     *           "id": "user-2",
     *           "values": {
     *             "country": "CAN"
     *           }
     *         }
     *       ]
     *   }
     * ```
     */
    protected String[] includedProperties;
    /**
     * **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended items be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    protected Double diversity;
    /**
     * Dictionary of custom options.
     */
    protected Map<String, Object> expertSettings;

    /**
     * Construct the request
     * @param itemId ID of the item for which the recommendations are to be generated.
     * @param count Number of items to be recommended (N for the top-N recommendation).
     */
    public RecommendUsersToItem (String itemId,long count) {
        this.itemId = itemId;
        this.count = count;
        this.timeout = 3000;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended items based on the values of their attributes.
     */
    public RecommendUsersToItem setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some items based on the values of their attributes.
     */
    public RecommendUsersToItem setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param cascadeCreate If item of given *itemId* doesn't exist in the database, it creates the missing item.
     */
    public RecommendUsersToItem setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param scenario Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing". You can see each scenario in the UI separately, so you can check how well each application performs. The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    public RecommendUsersToItem setScenario(String scenario) {
         this.scenario = scenario;
         return this;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the recommended users are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying the recommended users. 
     * Example response:
     * ```
     *   {
     *     "recommId": "9eeebc318508302529e3241f4570834d",
     *     "recomms":
     *       [
     *         {
     *           "id": "user-17",
     *           "values": {
     *             "country": "US",
     *             "sex": "F"
     *           }
     *         },
     *         {
     *           "id": "user-2",
     *           "values": {
     *             "country": "CAN",
     *             "sex": "M"
     *           }
     *         }
     *       ]
     *   }
     * ```
     */
    public RecommendUsersToItem setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   {
     *     "recommId": "d4c826635efc3e01a83470008c5697f1",
     *     "recomms":
     *       [
     *         {
     *           "id": "user-17",
     *           "values": {
     *             "country": "US"
     *           }
     *         },
     *         {
     *           "id": "user-2",
     *           "values": {
     *             "country": "CAN"
     *           }
     *         }
     *       ]
     *   }
     * ```
     */
    public RecommendUsersToItem setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param diversity **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended items be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    public RecommendUsersToItem setDiversity(double diversity) {
         this.diversity = diversity;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public RecommendUsersToItem setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    public String getItemId() {
         return this.itemId;
    }

    public long getCount() {
         return this.count;
    }

    public String getFilter() {
         return this.filter;
    }

    public String getBooster() {
         return this.booster;
    }

    public boolean getCascadeCreate() {
         if (this.cascadeCreate==null) return false;
         return this.cascadeCreate;
    }

    public String getScenario() {
         return this.scenario;
    }

    public boolean getReturnProperties() {
         if (this.returnProperties==null) return false;
         return this.returnProperties;
    }

    public String[] getIncludedProperties() {
         return this.includedProperties;
    }

    public double getDiversity() {
         return this.diversity;
    }

    public Map<String, Object> getExpertSettings() {
         return this.expertSettings;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.POST;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/recomms/items/%s/users/", this.itemId);
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        return params;
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("count", this.count);
        if (this.filter!=null) {
            params.put("filter", this.filter);
        }
        if (this.booster!=null) {
            params.put("booster", this.booster);
        }
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        if (this.scenario!=null) {
            params.put("scenario", this.scenario);
        }
        if (this.returnProperties!=null) {
            params.put("returnProperties", this.returnProperties);
        }
        if (this.includedProperties!=null) {
            params.put("includedProperties", this.includedProperties);
        }
        if (this.diversity!=null) {
            params.put("diversity", this.diversity);
        }
        if (this.expertSettings!=null) {
            params.put("expertSettings", this.expertSettings);
        }
        return params;
    }

}
