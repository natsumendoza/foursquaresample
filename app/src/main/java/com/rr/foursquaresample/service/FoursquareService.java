package com.rr.foursquaresample.service;


import com.rr.foursquaresample.model.FoursquareJSON;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoursquareService {

    @GET("venues/explore?v=20180316")
    Call<FoursquareJSON> getVenueRecommendations(@Query("client_id") String clientId,
                                                 @Query("client_secret") String clientSecret,
                                                 @Query("near") String near);

}
