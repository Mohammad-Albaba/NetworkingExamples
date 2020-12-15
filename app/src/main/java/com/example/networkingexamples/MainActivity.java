package com.example.networkingexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.net.http.AndroidHttpClient;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.google.android.material.snackbar.Snackbar;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity {

    //    String url = "http://api.geonames.org/earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=omaralbelbaisy";
    private RecyclerView earthQuakeRecyclerView;
    private List<EarthQuake> earthQuakes;
    private EarthQuakeAdapter earthQuakeAdapter;
    private NetworkUtils networkUtils;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        networkUtils = NetworkUtils.getInstance(this);
        earthQuakes = new ArrayList<>();
        earthQuakeRecyclerView = findViewById(R.id.recycler);
        earthQuakeRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        earthQuakeAdapter = new EarthQuakeAdapter(earthQuakes);
        earthQuakeRecyclerView.setAdapter(earthQuakeAdapter);

    }

    public void loadData(View view) {
        String url = networkUtils.getDataUrl();
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                earthQuakes.addAll(DataParser.parserEarthQuakeDate(response));
                earthQuakeAdapter.notifyDataSetChanged();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                if (error != null){
                Snackbar.make(view.getRootView() , error.getMessage(),Snackbar.LENGTH_LONG).show();
            }
            }
        });
        networkUtils.addToRequestQueue(request);



//            NetworkUtils.getInstance().getData(new OnResponseListener() {
//                @Override
//                public void onResponse(String response) {
//                    earthQuakes.addAll(DataParser.parserEarthQuakeDate(response));
//                    earthQuakeAdapter.notifyDataSetChanged();
//                }
//            }, new OnFailureListener() {
//                @Override
//                public void onError(String error) {
//                    Snackbar.make(view.getRootView() ,error ,Snackbar.LENGTH_LONG).show();
//                }
//            });
//        }
    }
}





//    // الكود اللي بالأسفل بحكس عن ارسال الطلب باستخدام ال أندرويد أتش تتيبي كلينت  *** Sending HTTP Requests by : Android Http client   ***
//    private void loadDataFromWeb() throws IOException {
//        AndroidHttpClient androidHttpClient = AndroidHttpClient.newInstance(null);
//        HttpGet httpGetRequest = new HttpGet(url);
//        ResponseHandler<String> responseHandler = new BasicResponseHandler();
//        String response = androidHttpClient.execute(httpGetRequest , responseHandler);
//        androidHttpClient.close();
//        textView.setText(response);
//    }



      // الكود اللي بالأسفل بحكس عن ارسال الطلب باستخدام ال سوكيت   ***Sending HTTP Requests by : Socket  ***
   /* private void loadDataFromWeb() throws IOException {
        String host = "api.geonames.org";
        String httpRequest = "GET /earthquakesJSON?formatted=true&north=44.1&south=-9.9&east=-22.4&west=55.2&username=omaralbelbaisy HTTP/1.1"
                + "\n"
                + "Host: " + host
                + "\n"
                + "Connection: close"
                + "\n\n";
        Socket socket = new Socket(host, 80);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
        PrintWriter printWriter = new PrintWriter(outputStreamWriter, true);
        printWriter.println(httpRequest);

        InputStream inputStream = socket.getInputStream();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            builder.append(line);
        }
        bufferedReader.close();
        textView.setText(builder.toString());

    }*/


