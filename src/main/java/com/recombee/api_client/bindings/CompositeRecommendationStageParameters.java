package com.recombee.api_client.bindings;

/*
 This file is auto-generated, do not edit
*/

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CompositeRecommendationStageParameters extends RecombeeBinding {
    /**
     * With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used to easily display the recommended items to the user. 
     * Example response with `returnProperties` set in the `resultSettings`:
     * ```json
     *     {
     *       "recommId": "ee94fa8b-efe7-4b35-abc6-2bc3456d66ed",
     *       "source": {
     *         "id": "category-sport"
     *       },
     *       "recomms": [
     *         {
     *           "id": "article-1024",
     *           "values": {
     *             "title": "Champions League: Stunning Comeback Secures Final Spot",
     *             "categories": ["Sport", "Football"],
     *             "author": "Jane Smith",
     *             "url": "newsportal.com/articles/champions-league-comeback"
     *           }
     *         },
     *         {
     *           "id": "article-2031",
     *           "values": {
     *             "title": "Top 10 Moments from the Summer Olympics",
     *             "categories": ["Sport", "Olympics"],
     *             "author": "Mark Johnson",
     *             "url": "newsportal.com/articles/olympic-top-moments"
     *           }
     *         },
     *         {
     *           "id": "article-3042",
     *           "values": {
     *             "title": "Rising Stars in Women's Tennis to Watch This Season",
     *             "categories": ["Sport", "Tennis"],
     *             "author": "Laura Chen",
     *             "url": "newsportal.com/articles/womens-tennis-stars"
     *           }
     *         }
     *       ],
     *       "numberNextRecommsCalls": 0
     *     }
     * ```
     */
    protected Boolean returnProperties;
    /**
     * Allows specifying which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list.
     * Example response for  `returnProperties=true` and `includedProperties=title,url` set in `resultSettings`:
     * ```json
     *   {
     *     "recommId": "ee94fa8b-efe7-4b35-abc6-2bc3456d66ed",
     *     "source": {
     *       "id": "category-sport"
     *     },
     *     "recomms": [
     *       {
     *         "id": "article-1024",
     *         "values": {
     *           "title": "Champions League: Stunning Comeback Secures Final Spot",
     *           "url": "newsportal.com/articles/champions-league-comeback"
     *         }
     *       },
     *       {
     *         "id": "article-2031",
     *         "values": {
     *           "title": "Top 10 Moments from the Summer Olympics",
     *           "url": "newsportal.com/articles/olympic-top-moments"
     *         }
     *       },
     *       {
     *         "id": "article-3042",
     *         "values": {
     *           "title": "Rising Stars in Women's Tennis to Watch This Season",
     *           "url": "newsportal.com/articles/womens-tennis-stars"
     *         }
     *       }
     *     ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    protected String[] includedProperties;
    /**
     * Boolean-returning [ReQL](https://docs.recombee.com/reql) expression, which allows you to filter recommended entities based on the values of their attributes.
     * Filters can also be assigned to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    protected String filter;
    /**
     * Number-returning [ReQL](https://docs.recombee.com/reql) expression, which allows you to boost the recommendation rate of some entities based on the values of their attributes.
     * Boosters can also be assigned to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    protected String booster;
    /**
     * Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    protected Logic logic;
    /**
     * Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * - [Recommend Users to Item](https://docs.recombee.com/api#recommend-users-to-item)
     * - [Recommend Users To User](https://docs.recombee.com/api#recommend-users-to-user)
     * A dictionary of [ReQL](https://docs.recombee.com/reql) expressions that will be executed for each recommended item.
     * This can be used to compute additional properties of the recommended items that are not stored in the database.
     * The keys are the names of the expressions, and the values are the actual ReQL expressions.
     * Example request:
     * ```json
     * {
     *   "reqlExpressions": {
     *     "isInUsersCity": "context_user[\"city\"] in 'cities'",
     *     "distanceToUser": "earth_distance('location', context_user[\"location\"])"
     *   }
     * }
     * ```
     * Example response:
     * ```json
     * {
     *   "recommId": "ce52ada4-e4d9-4885-943c-407db2dee837",
     *   "source": {
     *     "id": "restaurant-123",
     *     "reqlEvaluations": {
     *       "isInUsersCity": true,
     *       "distanceToUser": 3450.5
     *     }
     *   },
     *   "recomms": 
     *     [
     *       {
     *         "id": "restaurant-178",
     *         "reqlEvaluations": {
     *           "isInUsersCity": true,
     *           "distanceToUser": 5200.2
     *         }
     *       },
     *       {
     *         "id": "bar-42",
     *         "reqlEvaluations": {
     *           "isInUsersCity": false,
     *           "distanceToUser": 2516.0
     *         }
     *       }
     *     ],
     *    "numberNextRecommsCalls": 0
     * }
     * ```
     */
    protected Map<String, String> reqlExpressions;
    /**
     * **Expert option:** Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * If the *userId* is provided:  Specifies the threshold of how relevant must the recommended items be to the user.
     * Possible values one of: `"low"`, `"medium"`, `"high"`.
     * The default value is `"low"`, meaning that the system attempts to recommend a number of items equal to *count* at any cost. If there is not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations being appended to reach the full *count*.
     * This behavior may be suppressed by using `"medium"` or `"high"` values. In such case, the system only recommends items of at least the requested relevance and may return less than *count* items when there is not enough data to fulfill it.
     */
    protected String minRelevance;
    /**
     * **Expert option:** Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * - [Recommend Users To User](https://docs.recombee.com/api#recommend-users-to-user)
     * If the *userId* is provided: If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per request in a backward fashion.
     * You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example, `rotationRate=0.2` for only slight rotation of recommended items.
     */
    protected Double rotationRate;
    /**
     * **Expert option:** Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * - [Recommend Users To User](https://docs.recombee.com/api#recommend-users-to-user)
     * If the *userId* is provided: Taking *rotationRate* into account, specifies how long it takes for an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized.
     */
    protected Double rotationTime;

    public CompositeRecommendationStageParameters () {}

    public CompositeRecommendationStageParameters (boolean returnProperties,String[] includedProperties,String filter,String booster,Logic logic,Map<String, String> reqlExpressions,String minRelevance,double rotationRate,double rotationTime) {
        this.returnProperties = returnProperties;
        this.includedProperties = includedProperties;
        this.filter = filter;
        this.booster = booster;
        this.logic = logic;
        this.reqlExpressions = reqlExpressions;
        this.minRelevance = minRelevance;
        this.rotationRate = rotationRate;
        this.rotationTime = rotationTime;
    }

    public CompositeRecommendationStageParameters (Map<String, Object> jsonObject) {
        this.returnProperties = (Boolean) jsonObject.get("returnProperties");
        this.includedProperties = (String[]) jsonObject.get("includedProperties");
        this.filter = (String) jsonObject.get("filter");
        this.booster = (String) jsonObject.get("booster");
        this.logic = (Logic) jsonObject.get("logic");
        this.reqlExpressions = (Map<String, String>) jsonObject.get("reqlExpressions");
        this.minRelevance = (String) jsonObject.get("minRelevance");
        this.rotationRate = (Double) jsonObject.get("rotationRate");
        this.rotationTime = (Double) jsonObject.get("rotationTime");
    }

    public Boolean getReturnProperties() {
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

    public Map<String, String> getReqlExpressions() {
         return this.reqlExpressions;
    }

    public String getMinRelevance() {
         return this.minRelevance;
    }

    public Double getRotationRate() {
         return this.rotationRate;
    }

    public Double getRotationTime() {
         return this.rotationTime;
    }

    /**
     * @param returnProperties With `returnProperties=true`, property values of the recommended items are returned along with their IDs in a JSON dictionary. The acquired property values can be used to easily display the recommended items to the user. 
     * Example response with `returnProperties` set in the `resultSettings`:
     * ```json
     *     {
     *       "recommId": "ee94fa8b-efe7-4b35-abc6-2bc3456d66ed",
     *       "source": {
     *         "id": "category-sport"
     *       },
     *       "recomms": [
     *         {
     *           "id": "article-1024",
     *           "values": {
     *             "title": "Champions League: Stunning Comeback Secures Final Spot",
     *             "categories": ["Sport", "Football"],
     *             "author": "Jane Smith",
     *             "url": "newsportal.com/articles/champions-league-comeback"
     *           }
     *         },
     *         {
     *           "id": "article-2031",
     *           "values": {
     *             "title": "Top 10 Moments from the Summer Olympics",
     *             "categories": ["Sport", "Olympics"],
     *             "author": "Mark Johnson",
     *             "url": "newsportal.com/articles/olympic-top-moments"
     *           }
     *         },
     *         {
     *           "id": "article-3042",
     *           "values": {
     *             "title": "Rising Stars in Women's Tennis to Watch This Season",
     *             "categories": ["Sport", "Tennis"],
     *             "author": "Laura Chen",
     *             "url": "newsportal.com/articles/womens-tennis-stars"
     *           }
     *         }
     *       ],
     *       "numberNextRecommsCalls": 0
     *     }
     * ```
     */
    public CompositeRecommendationStageParameters setReturnProperties(boolean returnProperties) {
         this.returnProperties = returnProperties;
         return this;
    }

    /**
     * @param includedProperties Allows specifying which properties should be returned when `returnProperties=true` is set. The properties are given as a comma-separated list.
     * Example response for  `returnProperties=true` and `includedProperties=title,url` set in `resultSettings`:
     * ```json
     *   {
     *     "recommId": "ee94fa8b-efe7-4b35-abc6-2bc3456d66ed",
     *     "source": {
     *       "id": "category-sport"
     *     },
     *     "recomms": [
     *       {
     *         "id": "article-1024",
     *         "values": {
     *           "title": "Champions League: Stunning Comeback Secures Final Spot",
     *           "url": "newsportal.com/articles/champions-league-comeback"
     *         }
     *       },
     *       {
     *         "id": "article-2031",
     *         "values": {
     *           "title": "Top 10 Moments from the Summer Olympics",
     *           "url": "newsportal.com/articles/olympic-top-moments"
     *         }
     *       },
     *       {
     *         "id": "article-3042",
     *         "values": {
     *           "title": "Rising Stars in Women's Tennis to Watch This Season",
     *           "url": "newsportal.com/articles/womens-tennis-stars"
     *         }
     *       }
     *     ],
     *     "numberNextRecommsCalls": 0
     *   }
     * ```
     */
    public CompositeRecommendationStageParameters setIncludedProperties(String[] includedProperties) {
         this.includedProperties = includedProperties;
         return this;
    }

    /**
     * @param filter Boolean-returning [ReQL](https://docs.recombee.com/reql) expression, which allows you to filter recommended entities based on the values of their attributes.
     * Filters can also be assigned to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    public CompositeRecommendationStageParameters setFilter(String filter) {
         this.filter = filter;
         return this;
    }

    /**
     * @param booster Number-returning [ReQL](https://docs.recombee.com/reql) expression, which allows you to boost the recommendation rate of some entities based on the values of their attributes.
     * Boosters can also be assigned to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    public CompositeRecommendationStageParameters setBooster(String booster) {
         this.booster = booster;
         return this;
    }

    /**
     * @param logic Logic specifies the particular behavior of the recommendation models. You can pick tailored logic for your domain and use case.
     * See [this section](https://docs.recombee.com/recommendation_logics) for a list of available logics and other details.
     * The difference between `logic` and `scenario` is that `logic` specifies mainly behavior, while `scenario` specifies the place where recommendations are shown to the users.
     * Logic can also be set to a [scenario](https://docs.recombee.com/scenarios) in the [Admin UI](https://admin.recombee.com).
     */
    public CompositeRecommendationStageParameters setLogic(Logic logic) {
         this.logic = logic;
         return this;
    }

    /**
     * @param reqlExpressions Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * - [Recommend Users to Item](https://docs.recombee.com/api#recommend-users-to-item)
     * - [Recommend Users To User](https://docs.recombee.com/api#recommend-users-to-user)
     * A dictionary of [ReQL](https://docs.recombee.com/reql) expressions that will be executed for each recommended item.
     * This can be used to compute additional properties of the recommended items that are not stored in the database.
     * The keys are the names of the expressions, and the values are the actual ReQL expressions.
     * Example request:
     * ```json
     * {
     *   "reqlExpressions": {
     *     "isInUsersCity": "context_user[\"city\"] in 'cities'",
     *     "distanceToUser": "earth_distance('location', context_user[\"location\"])"
     *   }
     * }
     * ```
     * Example response:
     * ```json
     * {
     *   "recommId": "ce52ada4-e4d9-4885-943c-407db2dee837",
     *   "source": {
     *     "id": "restaurant-123",
     *     "reqlEvaluations": {
     *       "isInUsersCity": true,
     *       "distanceToUser": 3450.5
     *     }
     *   },
     *   "recomms": 
     *     [
     *       {
     *         "id": "restaurant-178",
     *         "reqlEvaluations": {
     *           "isInUsersCity": true,
     *           "distanceToUser": 5200.2
     *         }
     *       },
     *       {
     *         "id": "bar-42",
     *         "reqlEvaluations": {
     *           "isInUsersCity": false,
     *           "distanceToUser": 2516.0
     *         }
     *       }
     *     ],
     *    "numberNextRecommsCalls": 0
     * }
     * ```
     */
    public CompositeRecommendationStageParameters setReqlExpressions(Map<String, String> reqlExpressions) {
         this.reqlExpressions = reqlExpressions;
         return this;
    }

    /**
     * @param minRelevance **Expert option:** Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * If the *userId* is provided:  Specifies the threshold of how relevant must the recommended items be to the user.
     * Possible values one of: `"low"`, `"medium"`, `"high"`.
     * The default value is `"low"`, meaning that the system attempts to recommend a number of items equal to *count* at any cost. If there is not enough data (such as interactions or item properties), this may even lead to bestseller-based recommendations being appended to reach the full *count*.
     * This behavior may be suppressed by using `"medium"` or `"high"` values. In such case, the system only recommends items of at least the requested relevance and may return less than *count* items when there is not enough data to fulfill it.
     */
    public CompositeRecommendationStageParameters setMinRelevance(String minRelevance) {
         this.minRelevance = minRelevance;
         return this;
    }

    /**
     * @param rotationRate **Expert option:** Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * - [Recommend Users To User](https://docs.recombee.com/api#recommend-users-to-user)
     * If the *userId* is provided: If your users browse the system in real-time, it may easily happen that you wish to offer them recommendations multiple times. Here comes the question: how much should the recommendations change? Should they remain the same, or should they rotate? Recombee API allows you to control this per request in a backward fashion.
     * You may penalize an item for being recommended in the near past. For the specific user, `rotationRate=1` means maximal rotation, `rotationRate=0` means absolutely no rotation. You may also use, for example, `rotationRate=0.2` for only slight rotation of recommended items.
     */
    public CompositeRecommendationStageParameters setRotationRate(double rotationRate) {
         this.rotationRate = rotationRate;
         return this;
    }

    /**
     * @param rotationTime **Expert option:** Only usable if the stage corresponds to the one of these recommendation endpoints:
     * - [Recommend Items To User](https://docs.recombee.com/api#recommend-items-to-user)
     * - [Recommend Items To Item](https://docs.recombee.com/api#recommend-items-to-item)
     * - [Recommend Items to Item Segment](https://docs.recombee.com/api#recommend-items-to-item-segment)
     * - [Recommend Users To User](https://docs.recombee.com/api#recommend-users-to-user)
     * If the *userId* is provided: Taking *rotationRate* into account, specifies how long it takes for an item to recover from the penalization. For example, `rotationTime=7200.0` means that items recommended less than 2 hours ago are penalized.
     */
    public CompositeRecommendationStageParameters setRotationTime(double rotationTime) {
         this.rotationTime = rotationTime;
         return this;
    }

    @Override
    public int hashCode() {
    return new HashCodeBuilder(17, 31).
        append(this.returnProperties).
        append(this.includedProperties).
        append(this.filter).
        append(this.booster).
        append(this.logic).
        append(this.reqlExpressions).
        append(this.minRelevance).
        append(this.rotationRate).
        append(this.rotationTime).
        toHashCode();
    }

    @Override
    public boolean equals(Object obj) {
         if (!(obj instanceof CompositeRecommendationStageParameters))
             return false;
         if (obj == this)
             return true;
    
         CompositeRecommendationStageParameters rhs = (CompositeRecommendationStageParameters) obj;
         return new EqualsBuilder().
            append(this.returnProperties, rhs.returnProperties).
            append(this.includedProperties, rhs.includedProperties).
            append(this.filter, rhs.filter).
            append(this.booster, rhs.booster).
            append(this.logic, rhs.logic).
            append(this.reqlExpressions, rhs.reqlExpressions).
            append(this.minRelevance, rhs.minRelevance).
            append(this.rotationRate, rhs.rotationRate).
            append(this.rotationTime, rhs.rotationTime).
            isEquals();
    }
}
