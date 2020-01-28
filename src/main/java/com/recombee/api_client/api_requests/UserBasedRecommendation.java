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
 * It is also possible to use POST HTTP method (for example in case of very long ReQL filter) - query parameters then become body parameters.
 * @deprecated Deprecated since version 2.0.0. Use RecommendItemsToUser request instead.
 */
@Deprecated
public class UserBasedRecommendation extends Request {

    /**
     * ID of the user for whom the personalized recommendations are to be generated.
     */
    protected String userId;
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
     * If the user does not exist in the database, returns a list of non-personalized recommendations instead of causing HTTP 404 error. It doesn't create the user in the database.
     */
    protected Boolean allowNonexistent;
    /**
     * If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows for example rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    protected Boolean cascadeCreate;
    /**
     * Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing". You can see each scenario in the UI separately, so you can check how well each application performs. The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying of the recommended items to the user. 
     * Example response:
     * ```
     *   [
     *     {
     *       "itemId": "tv-178",
     *       "description": "4K TV with 3D feature",
     *       "categories":   ["Electronics", "Televisions"],
     *       "price": 342,
     *       "url": "myshop.com/tv-178"
     *     },
     *     {
     *       "itemId": "mixer-42",
     *       "description": "Stainless Steel Mixer",
     *       "categories":   ["Home & Kitchen"],
     *       "price": 39,
     *       "url": "myshop.com/mixer-42"
     *     }
     *   ]
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=description,price`:
     * ```
     *   [
     *     {
     *       "itemId": "tv-178",
     *       "description": "4K TV with 3D feature",
     *       "price": 342
     *     },
     *     {
     *       "itemId": "mixer-42",
     *       "description": "Stainless Steel Mixer",
     *       "price": 39
     *     }
     *   ]
     * ```
     */
    protected String[] includedProperties;
    /**
     * **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended items be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    protected Double diversity;
    /**
     * **Expert option** Specifies the threshold of how much relevant must the recommended items be to the user. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend number of items equal to *count* at any cost. If there are not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations to be appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends items of at least the requested qualit, and may return less than *count* items when there is not enough data to fulfill it.
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
     * Construct the request
     * @param userId ID of the user for whom the personalized recommendations are to be generated.
     * @param count Number of items to be recommended (N for the top-N recommendation).
     */
    public UserBasedRecommendation (String userId,long count) {
        this.userId = userId;
        this.count = count;
        this.timeout = 3000;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended items based on the values of their attributes.
     */
    public UserBasedRecommendation setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some items based on the values of their attributes.
     */
    public UserBasedRecommendation setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param allowNonexistent If the user does not exist in the database, returns a list of non-personalized recommendations instead of causing HTTP 404 error. It doesn't create the user in the database.
     */
    public UserBasedRecommendation setAllowNonexistent(boolean allowNonexistent) {
         this.allowNonexistent = allowNonexistent;
         return this;
    }

    /**
     * @param cascadeCreate If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows for example rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    public UserBasedRecommendation setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param scenario Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing". You can see each scenario in the UI separately, so you can check how well each application performs. The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    public UserBasedRecommendation setScenario(String scenario) {
         this.scenario = scenario;
         return this;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying of the recommended items to the user. 
     * Example response:
     * ```
     *   [
     *     {
     *       "itemId": "tv-178",
     *       "description": "4K TV with 3D feature",
     *       "categories":   ["Electronics", "Televisions"],
     *       "price": 342,
     *       "url": "myshop.com/tv-178"
     *     },
     *     {
     *       "itemId": "mixer-42",
     *       "description": "Stainless Steel Mixer",
     *       "categories":   ["Home & Kitchen"],
     *       "price": 39,
     *       "url": "myshop.com/mixer-42"
     *     }
     *   ]
     * ```
     */
    public UserBasedRecommendation setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=description,price`:
     * ```
     *   [
     *     {
     *       "itemId": "tv-178",
     *       "description": "4K TV with 3D feature",
     *       "price": 342
     *     },
     *     {
     *       "itemId": "mixer-42",
     *       "description": "Stainless Steel Mixer",
     *       "price": 39
     *     }
     *   ]
     * ```
     */
    public UserBasedRecommendation setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param diversity **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended items be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    public UserBasedRecommendation setDiversity(double diversity) {
         this.diversity = diversity;
         return this;
    }

    /**
     * @param minRelevance **Expert option** Specifies the threshold of how much relevant must the recommended items be to the user. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend number of items equal to *count* at any cost. If there are not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations to be appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends items of at least the requested qualit, and may return less than *count* items when there is not enough data to fulfill it.
     */
    public UserBasedRecommendation setMinRelevance(String minRelevance) {
         this.minRelevance = minRelevance;
         return this;
    }

    /**
     * @param rotationRate **Expert option** If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per-request in backward fashion. You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example `rotationRate=0.2` for only slight rotation of recommended items. Default: `0.1`.
     */
    public UserBasedRecommendation setRotationRate(double rotationRate) {
         this.rotationRate = rotationRate;
         return this;
    }

    /**
     * @param rotationTime **Expert option** Taking *rotationRate* into account, specifies how long time it takes to an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized. Default: `7200.0`.
     */
    public UserBasedRecommendation setRotationTime(double rotationTime) {
         this.rotationTime = rotationTime;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public UserBasedRecommendation setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    public String getUserId() {
         return this.userId;
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

    public boolean getAllowNonexistent() {
         if (this.allowNonexistent==null) return false;
         return this.allowNonexistent;
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
        return String.format("/users/%s/recomms/", this.userId);
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
        if (this.allowNonexistent!=null) {
            params.put("allowNonexistent", this.allowNonexistent);
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
        return params;
    }

}
