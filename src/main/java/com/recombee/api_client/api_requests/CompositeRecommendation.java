package com.recombee.api_client.api_requests;

/*
 This file is auto-generated, do not edit
*/

import java.util.Date;
import java.util.Map;
import java.util.HashMap;

import com.recombee.api_client.bindings.Logic;
import com.recombee.api_client.bindings.CompositeRecommendationStageParameters;
import com.recombee.api_client.util.HTTPMethod;

/**
 * Composite Recommendation returns both a *source entity* (e.g., an Item or [Item Segment](https://docs.recombee.com/segmentations)) and a list of related recommendations in a single response.
 * It is ideal for use cases such as personalized homepage sections (*Articles from &lt;category&gt;*), *Because You Watched &lt;movie&gt;*, or *Artists Related to Your Favorite Artist &lt;artist&gt;*.
 * See detailed **examples and configuration guidance** in the [Composite Scenarios documentation](https://docs.recombee.com/scenarios#composite-recommendations).
 * **Structure**
 * The endpoint operates in two stages:
 * 1. Recommends the *source* (e.g., an Item Segment or item) to the user.
 * 2. Recommends *results* (items or Item Segments) related to that *source*.
 * For example, *Articles from &lt;category&gt;* can be decomposed into:
 *   - [Recommend Item Segments To User](https://docs.recombee.com/api#recommend-item-segments-to-user) to find the category.
 *   - [Recommend Items To Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment) to recommend articles from that category.
 * Since the first step uses [Recommend Item Segments To User](https://docs.recombee.com/api#recommend-items-to-user), you must include the `userId` parameter in the *Composite Recommendation* request.
 * Each *Composite Recommendation* counts as a single recommendation API request for billing.
 * **Stage-specific Parameters**
 * Additional parameters can be supplied via [sourceSettings](https://docs.recombee.com/api#composite-recommendation-param-sourceSettings) and [resultSettings](https://docs.recombee.com/api#composite-recommendation-param-resultSettings).
 * In the example above:
 *   - `sourceSettings` may include any parameter valid for [Recommend Item Segments To User](https://docs.recombee.com/api#recommend-items-to-user) (e.g., `filter`, `booster`).
 *   - `resultSettings` may include any parameter valid for [Recommend Items To Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment).
 * See [this example](https://docs.recombee.com/api#composite-recommendation-example-setting-parameters-for-individual-stages) for more details.
 */
public class CompositeRecommendation extends Request {

    /**
     * Scenario defines a particular application of recommendations. It can be, for example, "homepage", "cart", or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com). You can also see the performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI that optimizes models to get the best results may optimize different scenarios separately or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * Number of items to be recommended (N for the top-N recommendation).
     */
    protected Long count;
    /**
     * ID of the item for which the recommendations are to be generated.
     */
    protected String itemId;
    /**
     * ID of the user for which the recommendations are to be generated.
     */
    protected String userId;
    /**
     * Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    protected Logic logic;
    /**
     * ID of the segment from `contextSegmentationId` for which the recommendations are to be generated.
     */
    protected String segmentId;
    /**
     * Search query provided by the user. It is used for the full-text search. Only applicable if the *scenario* corresponds to a search scenario.
     */
    protected String searchQuery;
    /**
     * If the entity for the source recommendation does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows, for example, rotations in the following recommendations for that entity, as the entity will be already known to the system.
     */
    protected Boolean cascadeCreate;
    /**
     * Parameters applied for recommending the *Source* stage. The accepted parameters correspond with the recommendation sub-endpoint used to recommend the *Source*.
     */
    protected CompositeRecommendationStageParameters sourceSettings;
    /**
     * Parameters applied for recommending the *Result* stage. The accepted parameters correspond with the recommendation sub-endpoint used to recommend the *Result*.
     */
    protected CompositeRecommendationStageParameters resultSettings;
    /**
     * Dictionary of custom options.
     */
    protected Map<String, Object> expertSettings;

    /**
     * Construct the request
     * @param scenario Scenario defines a particular application of recommendations. It can be, for example, "homepage", "cart", or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com). You can also see the performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI that optimizes models to get the best results may optimize different scenarios separately or even use different models in each of the scenarios.
     * @param count Number of items to be recommended (N for the top-N recommendation).
     */
    public CompositeRecommendation (String scenario,long count) {
        this.scenario = scenario;
        this.count = count;
        this.timeout = 3000;
    }

    /**
     * @param itemId ID of the item for which the recommendations are to be generated.
     */
    public CompositeRecommendation setItemId(String itemId) {
         this.itemId = itemId;
         return this;
    }

    /**
     * @param userId ID of the user for which the recommendations are to be generated.
     */
    public CompositeRecommendation setUserId(String userId) {
         this.userId = userId;
         return this;
    }

    /**
     * @param logic Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    public CompositeRecommendation setLogic(Logic logic) {
         this.logic = logic;
         return this;
    }

    /**
     * @param segmentId ID of the segment from `contextSegmentationId` for which the recommendations are to be generated.
     */
    public CompositeRecommendation setSegmentId(String segmentId) {
         this.segmentId = segmentId;
         return this;
    }

    /**
     * @param searchQuery Search query provided by the user. It is used for the full-text search. Only applicable if the *scenario* corresponds to a search scenario.
     */
    public CompositeRecommendation setSearchQuery(String searchQuery) {
         this.searchQuery = searchQuery;
         return this;
    }

    /**
     * @param cascadeCreate If the entity for the source recommendation does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows, for example, rotations in the following recommendations for that entity, as the entity will be already known to the system.
     */
    public CompositeRecommendation setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param sourceSettings Parameters applied for recommending the *Source* stage. The accepted parameters correspond with the recommendation sub-endpoint used to recommend the *Source*.
     */
    public CompositeRecommendation setSourceSettings(CompositeRecommendationStageParameters sourceSettings) {
         this.sourceSettings = sourceSettings;
         return this;
    }

    /**
     * @param resultSettings Parameters applied for recommending the *Result* stage. The accepted parameters correspond with the recommendation sub-endpoint used to recommend the *Result*.
     */
    public CompositeRecommendation setResultSettings(CompositeRecommendationStageParameters resultSettings) {
         this.resultSettings = resultSettings;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public CompositeRecommendation setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    public String getScenario() {
         return this.scenario;
    }

    public long getCount() {
         return this.count;
    }

    public String getItemId() {
         return this.itemId;
    }

    public String getUserId() {
         return this.userId;
    }

    public Logic getLogic() {
         return this.logic;
    }

    public String getSegmentId() {
         return this.segmentId;
    }

    public String getSearchQuery() {
         return this.searchQuery;
    }

    public boolean getCascadeCreate() {
         if (this.cascadeCreate==null) return false;
         return this.cascadeCreate;
    }

    public CompositeRecommendationStageParameters getSourceSettings() {
         return this.sourceSettings;
    }

    public CompositeRecommendationStageParameters getResultSettings() {
         return this.resultSettings;
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
        return "/recomms/composite/";
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
        params.put("scenario", this.scenario);
        params.put("count", this.count);
        if (this.itemId!=null) {
            params.put("itemId", this.itemId);
        }
        if (this.userId!=null) {
            params.put("userId", this.userId);
        }
        if (this.logic!=null) {
            params.put("logic", this.logic);
        }
        if (this.segmentId!=null) {
            params.put("segmentId", this.segmentId);
        }
        if (this.searchQuery!=null) {
            params.put("searchQuery", this.searchQuery);
        }
        if (this.cascadeCreate!=null) {
            params.put("cascadeCreate", this.cascadeCreate);
        }
        if (this.sourceSettings!=null) {
            params.put("sourceSettings", this.sourceSettings);
        }
        if (this.resultSettings!=null) {
            params.put("resultSettings", this.resultSettings);
        }
        if (this.expertSettings!=null) {
            params.put("expertSettings", this.expertSettings);
        }
        return params;
    }

}
