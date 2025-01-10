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
 * Recommends Items that are the most relevant to a particular Segment from a context [Segmentation](https://docs.recombee.com/segmentations.html).
 * Based on the used Segmentation, this endpoint can be used for example for:
 * - Recommending articles related to a particular topic
 * - Recommending songs belonging to a particular genre
 * - Recommending products produced by a particular brand
 * You need to set the used context Segmentation in the Admin UI in the [Scenario settings](https://docs.recombee.com/scenarios) prior to using this endpoint.
 * The returned items are sorted by relevance (the first item being the most relevant).
 * It is also possible to use the POST HTTP method (for example, in the case of a very long ReQL filter) — query parameters then become body parameters.
 */
public class RecommendItemsToItemSegment extends Request {

    /**
     * ID of the segment from `contextSegmentationId` for which the recommendations are to be generated.
     */
    protected String contextSegmentId;
    /**
     * ID of the user who will see the recommendations.
     * Specifying the *targetUserId* is beneficial because:
     * * It makes the recommendations personalized
     * * Allows the calculation of Actions and Conversions
     *   in the graphical user interface,
     *   as Recombee can pair the user who got recommendations
     *   and who afterward viewed/purchased an item.
     * If you insist on not specifying the user, pass `null`
     * (`None`, `nil`, `NULL` etc., depending on the language) to *targetUserId*.
     * Do not create some special dummy user for getting recommendations,
     * as it could mislead the recommendation models,
     * and result in wrong recommendations.
     * For anonymous/unregistered users, it is possible to use, for example, their session ID.
     */
    protected String targetUserId;
    /**
     * Number of items to be recommended (N for the top-N recommendation).
     */
    protected Long count;
    /**
     * Scenario defines a particular application of recommendations. It can be, for example, "homepage", "cart", or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com). You can also see the performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI that optimizes models to get the best results may optimize different scenarios separately or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * If an item of the given *itemId* or user of the given *targetUserId* doesn't exist in the database, it creates the missing entity/entities and returns some (non-personalized) recommendations. This allows, for example, rotations in the following recommendations for the user of the given *targetUserId*, as the user will be already known to the system.
     */
    protected Boolean cascadeCreate;
    /**
     * With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used to easily display the recommended items to the user. 
     * Example response:
     * ```
     *   {
     *     "recommId": "0c6189e7-dc1a-429a-b613-192696309361",
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
     *             "categories":   ["Home &amp; Kitchen"],
     *             "price": 39,
     *             "url": "myshop.com/mixer-42"
     *           }
     *         }
     *       ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows specifying which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list.
     * Example response for `includedProperties=description,price`:
     * ```
     *   {
     *     "recommId": "6842c725-a79f-4537-a02c-f34d668a3f80",
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
     * Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression, which allows you to filter recommended items based on the values of their attributes.
     * Filters can also be assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    protected String filter;
    /**
     * Number-returning [ReQL](https://docs.recombee.com/reql.html) expression, which allows you to boost the recommendation rate of some items based on the values of their attributes.
     * Boosters can also be assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    protected String booster;
    /**
     * Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics.html) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    protected Logic logic;
    /**
     * **Expert option** If the *targetUserId* is provided:  Specifies the threshold of how relevant must the recommended items be to the user. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend a number of items equal to *count* at any cost. If there is not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations being appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends items of at least the requested relevance and may return less than *count* items when there is not enough data to fulfill it.
     */
    protected String minRelevance;
    /**
     * **Expert option** If the *targetUserId* is provided: If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per request in a backward fashion. You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example, `rotationRate=0.2` for only slight rotation of recommended items.
     */
    protected Double rotationRate;
    /**
     * **Expert option** If the *targetUserId* is provided: Taking *rotationRate* into account, specifies how long it takes for an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized.
     */
    protected Double rotationTime;
    /**
     * Dictionary of custom options.
     */
    protected Map<String, Object> expertSettings;
    /**
     * If there is a custom AB-testing running, return the name of the group to which the request belongs.
     */
    protected Boolean returnAbGroup;

    /**
     * Construct the request
     * @param contextSegmentId ID of the segment from `contextSegmentationId` for which the recommendations are to be generated.
     * @param targetUserId ID of the user who will see the recommendations.
     * Specifying the *targetUserId* is beneficial because:
     * * It makes the recommendations personalized
     * * Allows the calculation of Actions and Conversions
     *   in the graphical user interface,
     *   as Recombee can pair the user who got recommendations
     *   and who afterward viewed/purchased an item.
     * If you insist on not specifying the user, pass `null`
     * (`None`, `nil`, `NULL` etc., depending on the language) to *targetUserId*.
     * Do not create some special dummy user for getting recommendations,
     * as it could mislead the recommendation models,
     * and result in wrong recommendations.
     * For anonymous/unregistered users, it is possible to use, for example, their session ID.
     * @param count Number of items to be recommended (N for the top-N recommendation).
     */
    public RecommendItemsToItemSegment (String contextSegmentId,String targetUserId,long count) {
        this.contextSegmentId = contextSegmentId;
        this.targetUserId = targetUserId;
        this.count = count;
        this.timeout = 3000;
    }

    /**
     * @param scenario Scenario defines a particular application of recommendations. It can be, for example, "homepage", "cart", or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com). You can also see the performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI that optimizes models to get the best results may optimize different scenarios separately or even use different models in each of the scenarios.
     */
    public RecommendItemsToItemSegment setScenario(String scenario) {
         this.scenario = scenario;
         return this;
    }

    /**
     * @param cascadeCreate If an item of the given *itemId* or user of the given *targetUserId* doesn't exist in the database, it creates the missing entity/entities and returns some (non-personalized) recommendations. This allows, for example, rotations in the following recommendations for the user of the given *targetUserId*, as the user will be already known to the system.
     */
    public RecommendItemsToItemSegment setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used to easily display the recommended items to the user. 
     * Example response:
     * ```
     *   {
     *     "recommId": "0c6189e7-dc1a-429a-b613-192696309361",
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
     *             "categories":   ["Home &amp; Kitchen"],
     *             "price": 39,
     *             "url": "myshop.com/mixer-42"
     *           }
     *         }
     *       ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    public RecommendItemsToItemSegment setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows specifying which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list.
     * Example response for `includedProperties=description,price`:
     * ```
     *   {
     *     "recommId": "6842c725-a79f-4537-a02c-f34d668a3f80",
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
    public RecommendItemsToItemSegment setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression, which allows you to filter recommended items based on the values of their attributes.
     * Filters can also be assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemsToItemSegment setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression, which allows you to boost the recommendation rate of some items based on the values of their attributes.
     * Boosters can also be assigned to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemsToItemSegment setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param logic Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics.html) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemsToItemSegment setLogic(Logic logic) {
         this.logic = logic;
         return this;
    }

    /**
     * @param minRelevance **Expert option** If the *targetUserId* is provided:  Specifies the threshold of how relevant must the recommended items be to the user. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend a number of items equal to *count* at any cost. If there is not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations being appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends items of at least the requested relevance and may return less than *count* items when there is not enough data to fulfill it.
     */
    public RecommendItemsToItemSegment setMinRelevance(String minRelevance) {
         this.minRelevance = minRelevance;
         return this;
    }

    /**
     * @param rotationRate **Expert option** If the *targetUserId* is provided: If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per request in a backward fashion. You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example, `rotationRate=0.2` for only slight rotation of recommended items.
     */
    public RecommendItemsToItemSegment setRotationRate(double rotationRate) {
         this.rotationRate = rotationRate;
         return this;
    }

    /**
     * @param rotationTime **Expert option** If the *targetUserId* is provided: Taking *rotationRate* into account, specifies how long it takes for an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized.
     */
    public RecommendItemsToItemSegment setRotationTime(double rotationTime) {
         this.rotationTime = rotationTime;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public RecommendItemsToItemSegment setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    /**
     * @param returnAbGroup If there is a custom AB-testing running, return the name of the group to which the request belongs.
     */
    public RecommendItemsToItemSegment setReturnAbGroup(boolean returnAbGroup) {
         this.returnAbGroup = returnAbGroup;
         return this;
    }

    public String getContextSegmentId() {
         return this.contextSegmentId;
    }

    public String getTargetUserId() {
         return this.targetUserId;
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
        return "/recomms/item-segments/items/";
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
        params.put("contextSegmentId", this.contextSegmentId);
        params.put("targetUserId", this.targetUserId);
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
