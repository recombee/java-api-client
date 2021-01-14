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
 * Based on user's past interactions (purchases, ratings, etc.) with the items, recommends top-N items that are most likely to be of high value for a given user.
 * The most typical use cases are recommendations at homepage, in some "Picked just for you" section or in email.
 * The returned items are sorted by relevance (first item being the most relevant).
 * Besides the recommended items, also a unique `recommId` is returned in the response. It can be used to:
 * - Let Recombee know that this recommendation was successful (e.g. user clicked one of the recommended items). See [Reported metrics](https://docs.recombee.com/admin_ui.html#reported-metrics).
 * - Get subsequent recommended items when the user scrolls down (*infinite scroll*) or goes to the next page. See [Recommend Next Items](https://docs.recombee.com/api.html#recommend-next-items).
 * It is also possible to use POST HTTP method (for example in case of very long ReQL filter) - query parameters then become body parameters.
 */
public class RecommendItemsToUser extends Request {

    /**
     * ID of the user for whom personalized recommendations are to be generated.
     */
    protected String userId;
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
     * If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows for example rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    protected Boolean cascadeCreate;
    /**
     * With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying of the recommended items to the user. 
     * Example response:
     * ```
     *   {
     *     "recommId": "ce52ada4-e4d9-4885-943c-407db2dee837",
     *     "recomms": 
     *       [
     *         {
     *           "id": "tv-178",
     *           "values": {
     *             "description": "4K TV with 3D feature",
     *             "categories":   ["Electronics", "Televisions"],
     *             "price": 342,
     *             "url": "myshop.com/tv-178"
     *           }
     *         },
     *         {
     *           "id": "mixer-42",
     *           "values": {
     *             "description": "Stainless Steel Mixer",
     *             "categories":   ["Home & Kitchen"],
     *             "price": 39,
     *             "url": "myshop.com/mixer-42"
     *           }
     *         }
     *       ],
     *      "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=description,price`:
     * ```
     *   {
     *     "recommId": "a86ee8d5-cd8e-46d1-886c-8b3771d0520b",
     *     "recomms":
     *       [
     *         {
     *           "id": "tv-178",
     *           "values": {
     *             "description": "4K TV with 3D feature",
     *             "price": 342
     *           }
     *         },
     *         {
     *           "id": "mixer-42",
     *           "values": {
     *             "description": "Stainless Steel Mixer",
     *             "price": 39
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
     * **Expert option** Specifies the threshold of how much relevant must the recommended items be to the user. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend number of items equal to *count* at any cost. If there are not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations to be appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends items of at least the requested relevance, and may return less than *count* items when there is not enough data to fulfill it.
     */
    protected String minRelevance;
    /**
     * **Expert option** If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per-request in backward fashion. You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example `rotationRate=0.2` for only slight rotation of recommended items. Default: `0.1`.
     */
    protected Double rotationRate;
    /**
     * **Expert option** Taking *rotationRate* into account, specifies how long time it takes to an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized. Default: `7200.0`.
     */
    protected Double rotationTime;
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
     * @param userId ID of the user for whom personalized recommendations are to be generated.
     * @param count Number of items to be recommended (N for the top-N recommendation).
     */
    public RecommendItemsToUser (String userId,long count) {
        this.userId = userId;
        this.count = count;
        this.timeout = 3000;
    }

    /**
     * @param scenario Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com). You can also see performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    public RecommendItemsToUser setScenario(String scenario) {
         this.scenario = scenario;
         return this;
    }

    /**
     * @param cascadeCreate If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows for example rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    public RecommendItemsToUser setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying of the recommended items to the user. 
     * Example response:
     * ```
     *   {
     *     "recommId": "ce52ada4-e4d9-4885-943c-407db2dee837",
     *     "recomms": 
     *       [
     *         {
     *           "id": "tv-178",
     *           "values": {
     *             "description": "4K TV with 3D feature",
     *             "categories":   ["Electronics", "Televisions"],
     *             "price": 342,
     *             "url": "myshop.com/tv-178"
     *           }
     *         },
     *         {
     *           "id": "mixer-42",
     *           "values": {
     *             "description": "Stainless Steel Mixer",
     *             "categories":   ["Home & Kitchen"],
     *             "price": 39,
     *             "url": "myshop.com/mixer-42"
     *           }
     *         }
     *       ],
     *      "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    public RecommendItemsToUser setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=description,price`:
     * ```
     *   {
     *     "recommId": "a86ee8d5-cd8e-46d1-886c-8b3771d0520b",
     *     "recomms":
     *       [
     *         {
     *           "id": "tv-178",
     *           "values": {
     *             "description": "4K TV with 3D feature",
     *             "price": 342
     *           }
     *         },
     *         {
     *           "id": "mixer-42",
     *           "values": {
     *             "description": "Stainless Steel Mixer",
     *             "price": 39
     *           }
     *         }
     *       ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    public RecommendItemsToUser setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended items based on the values of their attributes.
     * Filters can be also assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemsToUser setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some items based on the values of their attributes.
     * Boosters can be also assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemsToUser setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param logic Logic specifies particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics.html) for list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can be also set to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemsToUser setLogic(Logic logic) {
         this.logic = logic;
         return this;
    }

    /**
     * @param diversity **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended items be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    public RecommendItemsToUser setDiversity(double diversity) {
         this.diversity = diversity;
         return this;
    }

    /**
     * @param minRelevance **Expert option** Specifies the threshold of how much relevant must the recommended items be to the user. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend number of items equal to *count* at any cost. If there are not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations to be appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends items of at least the requested relevance, and may return less than *count* items when there is not enough data to fulfill it.
     */
    public RecommendItemsToUser setMinRelevance(String minRelevance) {
         this.minRelevance = minRelevance;
         return this;
    }

    /**
     * @param rotationRate **Expert option** If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per-request in backward fashion. You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example `rotationRate=0.2` for only slight rotation of recommended items. Default: `0.1`.
     */
    public RecommendItemsToUser setRotationRate(double rotationRate) {
         this.rotationRate = rotationRate;
         return this;
    }

    /**
     * @param rotationTime **Expert option** Taking *rotationRate* into account, specifies how long time it takes to an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized. Default: `7200.0`.
     */
    public RecommendItemsToUser setRotationTime(double rotationTime) {
         this.rotationTime = rotationTime;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public RecommendItemsToUser setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    /**
     * @param returnAbGroup If there is a custom AB-testing running, return name of group to which the request belongs.
     */
    public RecommendItemsToUser setReturnAbGroup(boolean returnAbGroup) {
         this.returnAbGroup = returnAbGroup;
         return this;
    }

    public String getUserId() {
         return this.userId;
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

    public String getMinRelevance() {
         return this.minRelevance;
    }

    public double getRotationRate() {
         return this.rotationRate;
    }

    public double getRotationTime() {
         return this.rotationTime;
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
        return String.format("/recomms/users/%s/items/", this.userId);
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
        if (this.minRelevance!=null) {
            params.put("minRelevance", this.minRelevance);
        }
        if (this.rotationRate!=null) {
            params.put("rotationRate", this.rotationRate);
        }
        if (this.rotationTime!=null) {
            params.put("rotationTime", this.rotationTime);
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
