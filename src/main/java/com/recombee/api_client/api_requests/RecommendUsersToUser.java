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
 * Get similar users as some given user, based on the user's past interactions (purchases, ratings, etc.) and values of properties.
 * It is also possible to use POST HTTP method (for example in case of very long ReQL filter) - query parameters then become body parameters.
 * The returned users are sorted by similarity (first user being the most similar).
 */
public class RecommendUsersToUser extends Request {

    /**
     * User to which we find similar users
     */
    protected String userId;
    /**
     * Number of users to be recommended (N for the top-N recommendation).
     */
    protected Long count;
    /**
     * Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended users based on the values of their attributes.
     */
    protected String filter;
    /**
     * Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some users based on the values of their attributes.
     */
    protected String booster;
    /**
     * If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows for example rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    protected Boolean cascadeCreate;
    /**
     * Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing". You can see each scenario in the UI separately, so you can check how well each application performs. The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    protected String scenario;
    /**
     * Logic specifies particular behavior of the recommendation models. You can pick tailored logic for your domain (e-commerce, multimedia, fashion ...) and use case.
     * See [this section](https://docs.recombee.com/recommendation_logic.html) for list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     */
    protected Logic logic;
    /**
     * With `returnProperties=true`, property values of the recommended users are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying the recommended users. 
     * Example response:
     * ```
     *   {
     *     "recommId": "9cb9c55d-50ba-4478-84fd-ab456136156e",
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
     *     }
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   {
     *     "recommId": "b326d82d-5d57-4b45-b362-c9d6f0895855",
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
     * **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended users be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    protected Double diversity;
    /**
     * **Expert option** Specifies the threshold of how much relevant must the recommended users be. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend number of users equal to *count* at any cost. If there are not enough data (such as interactions or user properties), this may even lead to bestseller-based recommendations to be appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends users of at least the requested relevancy, and may return less than *count* users when there is not enough data to fulfill it.
     */
    protected String minRelevance;
    /**
     * **Expert option** If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per-request in backward fashion. You may penalize an user for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example `rotationRate=0.2` for only slight rotation of recommended users.
     */
    protected Double rotationRate;
    /**
     * **Expert option** Taking *rotationRate* into account, specifies how long time it takes to an user to recover from the penalization. For example, `rotationTime=7200.0` means that users recommended less than 2 hours ago are penalized.
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
     * @param userId User to which we find similar users
     * @param count Number of users to be recommended (N for the top-N recommendation).
     */
    public RecommendUsersToUser (String userId,long count) {
        this.userId = userId;
        this.count = count;
        this.timeout = 50000;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to filter recommended users based on the values of their attributes.
     */
    public RecommendUsersToUser setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql.html) expression which allows you to boost recommendation rate of some users based on the values of their attributes.
     */
    public RecommendUsersToUser setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param cascadeCreate If the user does not exist in the database, returns a list of non-personalized recommendations and creates the user in the database. This allows for example rotations in the following recommendations for that user, as the user will be already known to the system.
     */
    public RecommendUsersToUser setCascadeCreate(boolean cascadeCreate) {
         this.cascadeCreate = cascadeCreate;
         return this;
    }

    /**
     * @param scenario Scenario defines a particular application of recommendations. It can be for example "homepage", "cart" or "emailing". You can see each scenario in the UI separately, so you can check how well each application performs. The AI which optimizes models in order to get the best results may optimize different scenarios separately, or even use different models in each of the scenarios.
     */
    public RecommendUsersToUser setScenario(String scenario) {
         this.scenario = scenario;
         return this;
    }

    /**
     * @param logic Logic specifies particular behavior of the recommendation models. You can pick tailored logic for your domain (e-commerce, multimedia, fashion ...) and use case.
     * See [this section](https://docs.recombee.com/recommendation_logic.html) for list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     */
    public RecommendUsersToUser setLogic(Logic logic) {
         this.logic = logic;
         return this;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the recommended users are returned along with their IDs in a JSON dictionary. The acquired property values can be used for easy displaying the recommended users. 
     * Example response:
     * ```
     *   {
     *     "recommId": "9cb9c55d-50ba-4478-84fd-ab456136156e",
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
     *     }
     * ```
     */
    public RecommendUsersToUser setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows to specify, which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list. 
     * Example response for `includedProperties=country`:
     * ```
     *   {
     *     "recommId": "b326d82d-5d57-4b45-b362-c9d6f0895855",
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
    public RecommendUsersToUser setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param diversity **Expert option** Real number from [0.0, 1.0] which determines how much mutually dissimilar should the recommended users be. The default value is 0.0, i.e., no diversification. Value 1.0 means maximal diversification.
     */
    public RecommendUsersToUser setDiversity(double diversity) {
         this.diversity = diversity;
         return this;
    }

    /**
     * @param minRelevance **Expert option** Specifies the threshold of how much relevant must the recommended users be. Possible values one of: "low", "medium", "high". The default value is "low", meaning that the system attempts to recommend number of users equal to *count* at any cost. If there are not enough data (such as interactions or user properties), this may even lead to bestseller-based recommendations to be appended to reach the full *count*. This behavior may be suppressed by using "medium" or "high" values. In such case, the system only recommends users of at least the requested relevancy, and may return less than *count* users when there is not enough data to fulfill it.
     */
    public RecommendUsersToUser setMinRelevance(String minRelevance) {
         this.minRelevance = minRelevance;
         return this;
    }

    /**
     * @param rotationRate **Expert option** If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per-request in backward fashion. You may penalize an user for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example `rotationRate=0.2` for only slight rotation of recommended users.
     */
    public RecommendUsersToUser setRotationRate(double rotationRate) {
         this.rotationRate = rotationRate;
         return this;
    }

    /**
     * @param rotationTime **Expert option** Taking *rotationRate* into account, specifies how long time it takes to an user to recover from the penalization. For example, `rotationTime=7200.0` means that users recommended less than 2 hours ago are penalized.
     */
    public RecommendUsersToUser setRotationTime(double rotationTime) {
         this.rotationTime = rotationTime;
         return this;
    }

    /**
     * @param expertSettings Dictionary of custom options.
     */
    public RecommendUsersToUser setExpertSettings(Map<String, Object> expertSettings) {
         this.expertSettings = expertSettings;
         return this;
    }

    /**
     * @param returnAbGroup If there is a custom AB-testing running, return name of group to which the request belongs.
     */
    public RecommendUsersToUser setReturnAbGroup(boolean returnAbGroup) {
         this.returnAbGroup = returnAbGroup;
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

    public boolean getCascadeCreate() {
         if (this.cascadeCreate==null) return false;
         return this.cascadeCreate;
    }

    public String getScenario() {
         return this.scenario;
    }

    public Logic getLogic() {
         return this.logic;
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
        return String.format("/recomms/users/%s/users/", this.userId);
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
        if (this.logic!=null) {
            params.put("logic", this.logic);
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
        if (this.returnAbGroup!=null) {
            params.put("returnAbGroup", this.returnAbGroup);
        }
        return params;
    }

}
