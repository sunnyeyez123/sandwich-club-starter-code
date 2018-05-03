package com.udacity.sandwichclub.utils;

import android.text.TextUtils;
import android.util.Log;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONException;
import org.json.JSONObject;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        //create a new sandwich
        Sandwich sandwich = null;

        // If the JSON string is empty or null, then return early.
        if (TextUtils.isEmpty(json)) {
            return null;
        }

        try{

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(json);

            String name = baseJsonResponse.getString("mainName");




        }catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("JsonUtils", "Problem parsing the  JSON results", e);
        }




        return sandwich;
    }
}
