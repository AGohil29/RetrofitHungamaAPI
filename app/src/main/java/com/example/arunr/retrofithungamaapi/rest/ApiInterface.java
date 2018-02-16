package com.example.arunr.retrofithungamaapi.rest;

import com.example.arunr.retrofithungamaapi.model.MovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by arun.r on 15-02-2018.
 */

public interface ApiInterface {

    @GET
    Call<MovieResponse> getMovieDetails(@Url String url);
    }
