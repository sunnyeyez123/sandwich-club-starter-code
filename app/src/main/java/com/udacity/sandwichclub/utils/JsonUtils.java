package com.udacity.sandwichclub.utils;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {


        try {

            // Create a JSONObject from the JSON response string
            JSONObject baseJsonResponse = new JSONObject(json);

            JSONObject names = baseJsonResponse.optJSONObject("name");
            String mainName = names.optString("mainName");
            JSONArray akaNameList = names.optJSONArray("alsoKnownAs");
            List<String> alsoKnownAs = new ArrayList<>();

            for (int i = 0; i < akaNameList.length(); i++) {
                alsoKnownAs.add(akaNameList.optString(i));
            }

            String origin = baseJsonResponse.optString("placeOfOrigin");
            String description = baseJsonResponse.optString("description");
            String image = baseJsonResponse.optString("image");

            JSONArray ingredientsList = baseJsonResponse.optJSONArray("ingredients");
            List<String> ingredients = new ArrayList<>();

            for (int i = 0; i < ingredientsList.length(); i++) {
                ingredients.add(ingredientsList.optString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, origin, description, image, ingredients);

        } catch (JSONException e) {
            // If an error is thrown when executing any of the above statements in the "try" block,
            // catch the exception here, so the app doesn't crash. Print a log message
            // with the message from the exception.
            Log.e("JsonUtils", "Problem parsing the  JSON results", e);
        }


        return null;
    }
}
