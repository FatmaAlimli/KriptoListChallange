package com.example.sample.RestApi;

import com.example.sample.Models.Response2;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface RestApi {
    @GET("/v1/public/coins")
    Call<Response2> bilgiGetir(@Header("packageName") String packageName);

    @GET("/v1/public/coins")
    Call<Response2> ozellikGetir(@Header("packageName") String packageName, @Query("id") String id);
}
