package com.example.lijiusi.finalproject;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.maps.MapView;
import com.yelp.fusion.client.connection.YelpFusionApi;
import com.yelp.fusion.client.connection.YelpFusionApiFactory;
import com.yelp.fusion.client.models.Business;



import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.android.volley.Request.*;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "final project";
    private static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);

        final TextView restaurantTextView = findViewById(R.id.restaurantTextView);
        Button randomBotton = findViewById(R.id.randomBotton);
        randomBotton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Restaurant a = RestaurantArr.generateRandom();

                startAPICall(a);
                //restaurantTextView.setText(RestaurantArr.generateRandom().getName());
            }
        });
    }

    /*
    void yelpAPICall() {
        try {
            YelpFusionApiFactory apiFactory = new YelpFusionApiFactory();
            YelpFusionApi yelpFusionApi = apiFactory.createAPI("XY3qKK8bXCSqfj5Fgzzac1JHIpTkGXySsYI5TIJyefWseq6lBhEyq7v0PFH9gTfpNHmSrLzxYtjFZjFVex4xx7ShYpLc3TZ6rSy_SNaoUngTs2Af0y8BKjfkyI0FXHYx");

            Callback<Business> callback = new Callback<Business>() {
                @Override
                public void onResponse(@NonNull Call<Business> call, Response<Business> response) {
                    Business business = response.body();
                    // Update UI text with the Business object.
                    TextView restaurantTextView = findViewById(R.id.restaurantTextView);
                    assert business != null;
                    if (business.getName() == null) {
                        restaurantTextView.setText(getString(R.string.temp));
                    } else {
                        restaurantTextView.setText(business.getName());
                    }
                }
                @Override
                public void onFailure(@NonNull Call<Business> call, @NonNull Throwable t) {
                    // HTTP error happened, do something to handle it.
                }
            };
            Call<Business> call = yelpFusionApi.getBusiness("WavvLdfdP6g8aZTtbBQHTw");
            call.enqueue(callback);
            if (isOnDestroyCalled) {
                call.cancel();
            }
        } catch(IOException ie) {
            ie.printStackTrace();
        }

    }
    private volatile boolean isOnDestroyCalled = false;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isOnDestroyCalled = true;
    }

    public boolean isOnDestroyCalled() {
        return this.isOnDestroyCalled;
    }

    */
    void startAPICall(final Restaurant a) {
        try {
            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                    Request.Method.GET,
                    a.getUrl(),
                    null,
                    new com.android.volley.Response.Listener<JSONObject>() {
                        @Override
                        public void onResponse(final JSONObject response) {
                            Log.d(TAG, response.toString());
                            processResponse(response, a);
                        }
                    }, new com.android.volley.Response.ErrorListener() {
                @Override
                public void onErrorResponse(final VolleyError error) {
                    Log.w(TAG, error.toString());
                }
            }) {
                public Map<String, String> getHeaders() {
                    Map<String, String> params = new HashMap<String, String>();
                    params.put("Authorization", "Bearer XY3qKK8bXCSqfj5Fgzzac1JHIpTkGXySsYI5TIJyefWseq6lBhEyq7v0PFH9gTfpNHmSrLzxYtjFZjFVex4xx7ShYpLc3TZ6rSy_SNaoUngTs2Af0y8BKjfkyI0FXHYx");
                    Log.d(TAG, params.toString());
                    return params;
                }
            };
            requestQueue.add(jsonObjectRequest);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint("SetTextI18n")
    void processResponse(final JSONObject response, final Restaurant a) {
        try {
            TextView restaurantTextView = findViewById(R.id.restaurantTextView);
            //restaurantTextView.setText(response.getJSONArray("hours").getJSONObject(0).getString("hours_type"));

            if (response.getJSONArray("hours").getJSONObject(0).getBoolean("is_open_now")) {
                restaurantTextView.setText(a.getName() + "!" + "\n" +
                        "AND!  It's open!!!.  It's gonna cost you " + a.getPrice() + "$");
            } else {
                restaurantTextView.setText(a.getName() + "!" + "\n" + "AND!  It's closed.");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}