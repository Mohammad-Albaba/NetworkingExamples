package com.example.networkingexamples;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataParser {

    public static List<EarthQuake> parserEarthQuakeDate(String jsonString){
         List<EarthQuake> earthQuakes = new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(jsonString);
            JSONArray jsonArray = jsonObject.getJSONArray("earthquakes");
            for (int i = 0; i<jsonArray.length() ; i++ ){
                JSONObject earthquakeJsonObject = jsonArray.getJSONObject(i);
                EarthQuake earthQuake = new EarthQuake();
//                System.out.println(earthquakeJsonObject.toString());
                earthQuake.setDaeTime(earthquakeJsonObject.getString("datetime"));
                earthQuake.setDepth(earthquakeJsonObject.getDouble("depth"));
                earthQuake.setLat(earthquakeJsonObject.getDouble("lat"));
                earthQuake.setLng(earthquakeJsonObject.getDouble("lng"));
                earthQuake.setMagnitude(earthquakeJsonObject.getDouble("magnitude"));
                earthQuake.setSource(earthquakeJsonObject.getString("src"));
                earthQuakes.add(earthQuake);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return earthQuakes;
    }
}