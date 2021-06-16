package com.example.fetchexercise;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.RequestParams;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.fetchexercise.adapters.DataAdapter;
import com.example.fetchexercise.models.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;


public class MainActivity extends AppCompatActivity {
    public static final String FETCH_URL="https://fetch-hiring.s3.amazonaws.com/hiring.json";
    public static final String TAG = "MainActivity";
    List<Data> data;
    RecyclerView rvData;
    DataAdapter dataAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rvData=findViewById(R.id.rvData);
        data= new ArrayList<>();
        //Creating adapter
        dataAdapter= new DataAdapter(this, data);
        //Assign the adapter to RecyclerView
        rvData.setAdapter(dataAdapter);
        //Set a Layout Manager
        rvData.setLayoutManager(new LinearLayoutManager(this));

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
       // params.put("limit", "5");
      // params.put("page", 2);

        client.get(FETCH_URL, params,new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Headers headers, JSON json) {

               // Log.d(TAG,"onSuccess");
                JSONArray jsonArray = json.jsonArray;
                try {
                    //JSONObject Result = jsonArray.getJSONObject(2);
                    //Log.i(TAG,"Results:" + Result.toString());
                   data.addAll(Data.fromJsonArray(jsonArray));
                    //Log.i(TAG,"Results: " + data.get(2).getName());
                   dataAdapter.notifyDataSetChanged();
                   // Log.i(TAG,"Array: " + data.size());

                } catch (JSONException e) {
                    Log.e(TAG,"Hit json exception",e);
                }


            }

            @Override
            public void onFailure(int i, Headers headers, String s, Throwable throwable) {
                Log.d(TAG,"onFailure");
            }
        });
    }
}