package com.example.arunr.retrofithungamaapi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;
import com.example.arunr.retrofithungamaapi.R;
import com.example.arunr.retrofithungamaapi.adapter.MoviesAdapter;
import com.example.arunr.retrofithungamaapi.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

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

            Glide.with(this)
                    .load(moviePoster)
                    // for rounded corners
                    .bitmapTransform(new RoundedCornersTransformation(this, 20, 0))
                    // for circle crop
                    //.bitmapTransform(new CropCircleTransformation(this))
                    //.fitCenter() // Scale to fit entire image within imageview
                    .placeholder(R.mipmap.ic_launcher)
                    .into(imageMovieDetails);
            movieTitle.setText(movieName);
            movieGenre.setText(genre);
            movieLang.setText(lang);
            movieDuration.setText(duration);
        }

    }
}
