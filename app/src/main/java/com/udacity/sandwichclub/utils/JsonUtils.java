package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {

        //The code below is my interpretation of mentor comments on the forums, stack overflow
        //and tutorials.

        try {

            JSONObject rootObject = new JSONObject(json);

            JSONObject name = rootObject.optJSONObject("name");

            String mainName = name.optString("mainName");

            JSONArray jsonArray = name.optJSONArray("alsoKnownAs");
            ArrayList<String> alsoKnownAs = new ArrayList<>();

            for (int i = 0; i < jsonArray.length(); i++) {
                alsoKnownAs.add(jsonArray.getString(i));
            }
            String placeOfOrigin = rootObject.optString("placeOfOrigin");

            String description = rootObject.optString("description");

            String image = rootObject.optString("image");

            JSONArray jsonArray1 = rootObject.getJSONArray("ingredients");
            ArrayList<String> ingredients = new ArrayList<>();

            for (int i = 0; i < jsonArray1.length(); i++) {
                ingredients.add(jsonArray1.optString(i));
            }

            return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);

        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
