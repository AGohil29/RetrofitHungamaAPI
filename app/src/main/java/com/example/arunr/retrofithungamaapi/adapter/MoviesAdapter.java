package com.example.arunr.retrofithungamaapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.arunr.retrofithungamaapi.R;
import com.example.arunr.retrofithungamaapi.activity.MovieDetails;
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

    public class MovieViewHolder extends RecyclerView.ViewHolder {
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

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if (pos != RecyclerView.NO_POSITION){
                        Movie clickedDataItem = movies.get(pos);
                        Intent intent = new Intent(context, MovieDetails.class);
                        intent.putExtra("name", movies.get(pos).getName());
                        intent.putExtra("image", movies.get(pos).getImages().get(0).getImage());
                        intent.putExtra("genre", movies.get(pos).getGenre());
                        intent.putExtra("lang", movies.get(pos).getLang());
                        intent.putExtra("duration", movies.get(pos).getDuration().toString());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        context.startActivity(intent);
                        Toast.makeText(v.getContext(), "You clicked " + clickedDataItem.getName(), Toast.LENGTH_SHORT).show();
                    }
                }
            });

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
