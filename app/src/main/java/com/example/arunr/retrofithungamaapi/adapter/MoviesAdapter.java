package com.example.arunr.retrofithungamaapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.arunr.retrofithungamaapi.R;
import com.example.arunr.retrofithungamaapi.model.Images;
import com.example.arunr.retrofithungamaapi.model.Movie;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arun.r on 15-02-2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MovieViewHolder> {
    public static final String TAG = MoviesAdapter.class.getSimpleName();

    private List<Movie> movies;
    private int rowLayout;
    private Context context;

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        ImageView imageView;
        TextView movieTitle;
        TextView movieLanguage;
        TextView movieGenre;

        public MovieViewHolder(View view) {
            super(view);
            moviesLayout = view.findViewById(R.id.movies_layout);
            imageView = view.findViewById(R.id.imageView);
            movieTitle = view.findViewById(R.id.title);
            movieLanguage = view.findViewById(R.id.language);
            movieGenre = view.findViewById(R.id.genre);

        }
    }

    public MoviesAdapter(List<Movie> movies, int rowLayout, Context context) {
        this.movies = movies;
        this.rowLayout = rowLayout;
        this.context = context;
    }

    @Override
    public MoviesAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(rowLayout, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getName());
        holder.movieLanguage.setText(movies.get(position).getLang());
        holder.movieGenre.setText(movies.get(position).getGenre());
        Picasso.with(context)
                .load(movies.get(position).getImages().get(0).getImage())
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imageView);
         Log.i(TAG, "Url of Image: " + movies.get(position).getImages().get(0).getImage());
    }
    // Checks whether the array is null
    /* public String getImageUrl(ArrayList<Images> list) {
      //  String str = "";

        //if (list != null && list.size() > 0) {
          //  str = list.get(0).getImage();
        //}

        //return str;
    }*/

    @Override
    public int getItemCount() {
        return movies.size();
    }
}
