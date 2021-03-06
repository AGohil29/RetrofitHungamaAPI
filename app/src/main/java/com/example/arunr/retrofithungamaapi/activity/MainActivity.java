package com.example.arunr.retrofithungamaapi.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.example.arunr.retrofithungamaapi.R;
import com.example.arunr.retrofithungamaapi.adapter.MoviesAdapter;
import com.example.arunr.retrofithungamaapi.model.Movie;
import com.example.arunr.retrofithungamaapi.model.MovieResponse;
import com.example.arunr.retrofithungamaapi.rest.ApiClient;
import com.example.arunr.retrofithungamaapi.rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final static String Url = "https://n-pvt.hungama.com/v2/content/movieapp/queue_data.json?device=1080x1920&section_id=1&genre=Gossip&bucket_id=5360&offset=0&user_type=1&version=2.0.10.7&app-id=e3MH8F20cr&limit=10&cp=33682232";
    List<Movie> movies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RecyclerView recyclerView = findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Decorate the items using various decorators
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        retrofit2.Call<MovieResponse> call = apiService.getMovieDetails(Url);
        call.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                // Accessing the appropriate array class in the Json file
                movies = response.body().getNode().getData();
                recyclerView.setAdapter(new MoviesAdapter(movies, R.layout.list_item_movie, getApplicationContext()));
//                Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
