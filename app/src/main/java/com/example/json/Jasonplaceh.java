package com.example.json;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Jasonplaceh {

    @GET("events")
    Call<List<Post>> getposts();
 }
