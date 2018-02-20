package com.example.arunr.retrofithungamaapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.arunr.retrofithungamaapi.R;
import com.example.arunr.retrofithungamaapi.adapter.MoviesAdapter;
import com.example.arunr.retrofithungamaapi.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun.r on 19-02-2018.
 */

public class MovieDetails extends AppCompatActivity {

    public ImageView imageMovieDetails;
    public TextView movieTitle, movieGenre, movieLang, movieDuration;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        // set views from movie_details layout
        ImageView imageMovieDetails = findViewById(R.id.imageMovieDetails);
        TextView movieTitle = findViewById(R.id.movieTitle);
        TextView movieGenre = findViewById(R.id.movieGenre);
        TextView movieLang = findViewById(R.id.movieLang);
        TextView movieDuration = findViewById(R.id.movieDuration);

        Intent intentThatStartedThisActivity = getIntent();
        if (intentThatStartedThisActivity.hasExtra("name")){

            String moviePoster = getIntent().getExtras().getString("image");
            String movieName = getIntent().getExtras().getString("name");
            String genre = getIntent().getExtras().getString("genre");
            String lang = getIntent().getExtras().getString("lang");
            String duration = getIntent().getExtras().getString("duration");

            Picasso.with(this)
                    .load(moviePoster)
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageMovieDetails);
            movieTitle.setText(movieName);
            movieGenre.setText(genre);
            movieLang.setText(lang);
            movieDuration.setText(duration);
        }

    }
}
