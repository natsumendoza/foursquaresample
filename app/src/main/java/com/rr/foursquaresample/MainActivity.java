package com.rr.foursquaresample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.rr.foursquaresample.model.FoursquareJSON;
import com.rr.foursquaresample.service.FoursquareService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private static final String BASE_URL = "https://api.foursquare.com/v2/";
    private static final String CLIENT_ID = "";
    private static final String CLIENT_SECRET = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: " + BASE_URL);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        FoursquareService foursquareService = retrofit.create(FoursquareService.class);

        String near = "Manila";

        Call<FoursquareJSON> recommendVenueCall = foursquareService.getVenueRecommendations(
                CLIENT_ID,
                CLIENT_SECRET,
                near
        );

        recommendVenueCall.enqueue(new Callback<FoursquareJSON>() {
            @Override
            public void onResponse(Call<FoursquareJSON> call, Response<FoursquareJSON> response) {
                Log.d(TAG, "onResponse: " + response.isSuccessful());
                try {
                    Log.d(TAG, "onResponse: " + response.errorBody().string());
                } catch (Exception e) {

                }
                if (response.isSuccessful()) {
                    FoursquareJSON foursquareJSON = response.body();
                    Log.d(TAG, "onResponse: name of venue: " + foursquareJSON.getResponse().getGroups().get(0).getItems().get(0).getVenue().getName());
                }
            }

            @Override
            public void onFailure(Call<FoursquareJSON> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.getMessage());
            }
        });

    }
}
