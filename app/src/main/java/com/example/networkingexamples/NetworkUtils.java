package com.example.networkingexamples;

import android.content.Context;
import android.net.Uri;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PipedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
//    // الكود اللي بالأسفل بحكس عن ارسال الطلب باستخدام ال أندرويد أتش تتيبي يورلكونيكشين  *** Sending HTTP Requests by : HttpURLConnection    ***

public class NetworkUtils {
    private final String BASE_URL = "http://api.geonames.org";
    private final String EARTHQUAKE_BATH = "/earthquakesJSON";

    // ?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=omaralbelbaisy المتغيرات تبعات ال يورل
    private final String PARAM_NORTH = "north" ;
    private final String PARAM_SOUTH = "south" ;
    private final String PARAM_EAST = "east" ;
    private final String PARAM_WEST = "west" ;
    private final String PARAM_USERNAME = "username" ;
    private final String USERNAME = "omaralbelbaisy" ;
    private RequestQueue requestQueue;

    private static NetworkUtils instance;

    public static NetworkUtils getInstance(Context context){
        if (instance == null){
            instance = new NetworkUtils(context.getApplicationContext());
        }
        return instance;
    }

    private NetworkUtils(Context context){
        requestQueue = Volley.newRequestQueue(context);

    }
    public String getDataUrl() {
        Uri uri = Uri.parse(BASE_URL + EARTHQUAKE_BATH).buildUpon()
                .appendQueryParameter(PARAM_USERNAME, USERNAME)
                .appendQueryParameter(PARAM_NORTH, "44.1")
                .appendQueryParameter(PARAM_SOUTH, "-9.9")
                .appendQueryParameter(PARAM_EAST, "-22.4")
                .appendQueryParameter(PARAM_WEST, "55.2")
                .build();
        return uri.toString();

    }

    public void addToRequestQueue(Request request){
        requestQueue.add(request);
    }







    //***Sending HTTP Requests by : HttpURLConnection  ***   الكود اللي بالأسفل بحكس عن ارسال الطلب باستخدام الشتتبي يورل كونيكشن
//    private void loadDataFromWeb(String url , OnResponseListener onResponseListener , OnFailureListener onFailureListener) {
//        AppExecutor.getInstance().getNetworkExecutor().execute(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    URL httpUrl = new URL(url);
//                    HttpURLConnection httpURLConnection = (HttpURLConnection) httpUrl.openConnection();
//                    httpURLConnection.setRequestMethod("GET");
//                    httpURLConnection.connect();
//                    InputStream inputStream = httpURLConnection.getInputStream();
//                    BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
//                    InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
//                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//                    StringBuilder builder = new StringBuilder();
//                    String line;
//                    while ((line = bufferedReader.readLine()) != null){
//                        builder.append(line);
//                    }
//                    bufferedReader.close();
//                    httpURLConnection.disconnect();
//
//                    AppExecutor.getInstance().getMainExecutor().execute(new Runnable() {
//                        @Override
//                        public void run() {
//                            onResponseListener.onResponse(builder.toString());
//                        }
//                    });
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    AppExecutor.getInstance().getMainExecutor().execute(new Runnable() {
//                        @Override
//                        public void run() {
//                            onFailureListener.onError(e.getMessage());
//                        }
//                    });
//                }
//            }
//        });
//
//
//    }

}