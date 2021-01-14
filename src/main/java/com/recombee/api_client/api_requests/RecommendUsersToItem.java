package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.bindings.Logic;
import com.recombee.api_client.util.HTTPMethod;

/**
 * Recommend users that are likely to be interested in a given item.
 * It is also possible to use POST HTTP method (for example in case of very long ReQL filter) - query parameters then become body parameters.
 * The returned users are sorted by predicted interest in the item (first user being the most interested).
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
     * Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com). You can also see performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * If item of given *itemId* doesn't exist in the database, it creates the missing item.
     */
    protected Boolean cascadeCreate;
    /**
     * With `returnProperties=true`, property values of the recommended users are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying the recommended users. 
     * Example response:
     * ```
     *   {
     *     "recommId": "039b71dc-b9cc-4645-a84f-62b841eecfce",
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
     *       ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   {
     *     "recommId": "b2b355dd-972a-4728-9c6b-2dc229db0678",
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
     *       ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    protected String[] includedProperties;
    /**
     * Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended items based on the values of their attributes.
     * Filters can be also assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    protected String filter;
    /**
     * Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some items based on the values of their attributes.
     * Boosters can be also assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    protected String booster;
    /**
     * Logic specifies particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics.html) for list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can be also set to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    protected Logic logic;
    /**
     * **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended items be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    protected Double diversity;
    /**
     * Dictionary of custom options.
     */
    protected Map<String, Object> expertSettings;
    /**
     * If there is a custom AB-testing running, return name of group to which the request belongs.
     */
    protected Boolean returnAbGroup;

    /**
     * Construct the request
     * @param itemId ID of the item for which the recommendations are to be generated.
     * @param count Number of items to be recommended (N for the top-N recommendation).
     */
    public RecommendUsersToItem (String itemId,long count) {
        this.itemId = itemId;
        this.count = count;
        this.timeout = 50000;
    }

    /**
     * @param scenario Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com). You can also see performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    public RecommendUsersToItem setScenario(String scenario) {
         this.scenario = scenario;
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
     * @param returnProperties With `returnProperties=true`, property values of the recommended users are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying the recommended users. 
     * Example response:
     * ```
     *   {
     *     "recommId": "039b71dc-b9cc-4645-a84f-62b841eecfce",
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
     *       ],
     *     "numberNextRecommsCalls": 0
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
     *     "recommId": "b2b355dd-972a-4728-9c6b-2dc229db0678",
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
     *       ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    public RecommendUsersToItem setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended items based on the values of their attributes.
     * Filters can be also assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendUsersToItem setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some items based on the values of their attributes.
     * Boosters can be also assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendUsersToItem setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param logic Logic specifies particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics.html) for list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can be also set to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendUsersToItem setLogic(Logic logic) {
         this.logic = logic;
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

    /**
     * @param returnAbGroup If there is a custom AB-testing running, return name of group to which the request belongs.
     */
    public RecommendUsersToItem setReturnAbGroup(boolean returnAbGroup) {
         this.returnAbGroup = returnAbGroup;
         return this;
    }

    public String getItemId() {
         return this.itemId;
    }

    public long getCount() {
         return this.count;
    }

    public String getScenario() {
         return this.scenario;
    }

    public boolean getCascadeCreate() {
         if (this.cascadeCreate==null) return false;
         return this.cascadeCreate;
    }

    public boolean getReturnProperties() {
         if (this.returnProperties==null) return false;
         return this.returnProperties;
    }

    public String[] getIncludedProperties() {
         return this.includedProperties;
    }

    public String getFilter() {
         return this.filter;
    }

    public String getBooster() {
         return this.booster;
    }

    public Logic getLogic() {
         return this.logic;
    }

    public double getDiversity() {
         return this.diversity;
    }

    public Map<String, Object> getExpertSettings() {
         return this.expertSettings;
    }

    public boolean getReturnAbGroup() {
         if (this.returnAbGroup==null) return false;
         return this.returnAbGroup;
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
        if (this.scenario!=null) {
            params.put("scenario", this.scenario);
        }
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        if (this.returnProperties!=null) {
            params.put("returnProperties", this.returnProperties);
        }
        if (this.includedProperties!=null) {
            params.put("includedProperties", this.includedProperties);
        }
        if (this.filter!=null) {
            params.put("filter", this.filter);
        }
        if (this.booster!=null) {
            params.put("booster", this.booster);
        }
        if (this.logic!=null) {
            params.put("logic", this.logic);
        }
        if (this.diversity!=null) {
            params.put("diversity", this.diversity);
        }
        if (this.expertSettings!=null) {
            params.put("expertSettings", this.expertSettings);
        }
        if (this.returnAbGroup!=null) {
            params.put("returnAbGroup", this.returnAbGroup);
        }
        return params;
    }

}
