package com.example.daggerapplication.data;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("search/shows")
    Call<List<String>> getSingleShow(@Query("q") String query);

    @GET("shows")
    Call<List<String>> shows();

    default String getApi() {
        return ApiService.class.toString();
    }
}
