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
 * Adding an item property is somehow equivalent to adding a column to the table of items. The items may be characterized by various properties of different types.
 */
public class AddItemProperty extends Request {

    /**
     * Name of the item property to be created. Currently, the following names are reserved:`id`, `itemid`, case insensitively. Also, the length of the property name must not exceed 63 characters.
     */
    protected String propertyName;
    /**
     * Value type of the item property to be created. One of: `int`, `double`, `string`, `boolean`, `timestamp`, `set`, `image` or `imageList`.
     * * `int`- Signed integer number.
     * * `double` - Floating point number. It uses 64-bit base-2 format (IEEE 754 standard).
     * * `string` - UTF-8 string.
     * * `boolean` - *true* / *false*
     * * `timestamp` - Value representing date and time.
     * * `set` - Set of strings.
     * * `image` - URL of an image (`jpeg`, `png` or `gif`).
     * * `imageList` - List of URLs that refer to images. 
     */
    protected String type;

    /**
     * Construct the request
     * @param propertyName Name of the item property to be created. Currently, the following names are reserved:`id`, `itemid`, case insensitively. Also, the length of the property name must not exceed 63 characters.
     * @param type Value type of the item property to be created. One of: `int`, `double`, `string`, `boolean`, `timestamp`, `set`, `image` or `imageList`.
     * * `int`- Signed integer number.
     * * `double` - Floating point number. It uses 64-bit base-2 format (IEEE 754 standard).
     * * `string` - UTF-8 string.
     * * `boolean` - *true* / *false*
     * * `timestamp` - Value representing date and time.
     * * `set` - Set of strings.
     * * `image` - URL of an image (`jpeg`, `png` or `gif`).
     * * `imageList` - List of URLs that refer to images. 
     */
    public AddItemProperty (String propertyName,String type) {
        this.propertyName = propertyName;
        this.type = type;
        this.timeout = 100000;
    }


    public String getPropertyName() {
         return this.propertyName;
    }

    public String getType() {
         return this.type;
    }

    /**
     * @return Used HTTP method
     */
    @Override
    public HTTPMethod getHTTPMethod() {
        return HTTPMethod.PUT;
    }

    /**
     * @return URI to the endpoint including path parameters
     */
    @Override
    public String getPath() {
        return String.format("/items/properties/%s", this.propertyName);
    }

    /**
     * Get query parameters
     * @return Values of query parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getQueryParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        params.put("type", this.type.toString());
        return params;
    }

    /**
     * Get body parameters
     * @return Values of body parameters (name of parameter: value of the parameter)
     */
    @Override
    public Map<String, Object> getBodyParameters() {
        HashMap<String, Object> params = new HashMap<String, Object>();
        return params;
    }

}
