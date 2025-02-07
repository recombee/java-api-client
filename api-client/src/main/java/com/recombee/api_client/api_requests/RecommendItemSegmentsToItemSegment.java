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
 * Recommends Segments from a result [Segmentation](https://docs.recombee.com/segmentations.html) that are the most relevant to a particular Segment from a context Segmentation.
 * Based on the used Segmentations, this endpoint can be used for example for:
 *   - Recommending the related brands to particular brand
 *   - Recommending the related brands to particular category
 *   - Recommending the related artists to a particular genre (assuming songs are the Items)
 * You need to set the used context and result Segmentation the Admin UI in the [Scenario settings](https://docs.recombee.com/scenarios) prior to using this endpoint.
 * The returned segments are sorted by relevance (first segment being the most relevant).
 * It is also possible to use POST HTTP method (for example in case of very long ReQL filter) - query parameters then become body parameters.
 */
public class RecommendItemSegmentsToItemSegment extends Request {

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
     * Number of item segments to be recommended (N for the top-N recommendation).
     */
    protected Long count;
    /**
     * Scenario defines a particular application of recommendations. It can be, for example, "homepage", "cart", or "emailing".
     * You can set various settings to the [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com). You can also see the performance of each scenario in the Admin UI separately, so you can check how well each application performs.
     * The AI that optimizes models to get the best results may optimize different scenarios separately or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows, for example, rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    protected Boolean cascadeCreate;
    /**
     * Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended segments based on the `segmentationId`.
     */
    protected String filter;
    /**
     * Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some segments based on the `segmentationId`.
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
     * @param count Number of item segments to be recommended (N for the top-N recommendation).
     */
    public RecommendItemSegmentsToItemSegment (String contextSegmentId,String targetUserId,long count) {
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
    public RecommendItemSegmentsToItemSegment setScenario(String scenario) {
         this.scenario = scenario;
         return this;
    }

    /**
     * @param cascadeCreate If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows, for example, rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    public RecommendItemSegmentsToItemSegment setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended segments based on the `segmentationId`.
     */
    public RecommendItemSegmentsToItemSegment setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some segments based on the `segmentationId`.
     */
    public RecommendItemSegmentsToItemSegment setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param logic Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics.html) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios.html) in the [Admin UI](https://admin.recombee.com).
     */
    public RecommendItemSegmentsToItemSegment setLogic(Logic logic) {
         this.logic = logic;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public RecommendItemSegmentsToItemSegment setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    /**
     * @param returnAbGroup If there is a custom AB-testing running, return the name of the group to which the request belongs.
     */
    public RecommendItemSegmentsToItemSegment setReturnAbGroup(boolean returnAbGroup) {
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

    public String getFilter() {
         return this.filter;
    }

    public String getBooster() {
         return this.booster;
    }

    public Logic getLogic() {
         return this.logic;
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
        return "/recomms/item-segments/item-segments/";
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
        if (this.filter!=null) {
            params.put("filter", this.filter);
        }
        if (this.booster!=null) {
            params.put("booster", this.booster);
        }
        if (this.logic!=null) {
            params.put("logic", this.logic);
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
