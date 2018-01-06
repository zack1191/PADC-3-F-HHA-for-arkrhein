package com.hha.heinhtetaung.movieshelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.movieshelf.R;
import com.hha.heinhtetaung.movieshelf.viewholders.MovieTrailerViewHolder;

/**
 * Created by E5 on 12/14/2017.
 */

public class MovieTrailerAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View movieTrailer = layoutInflater.inflate(R.layout.item_movie_images, parent, false);
        MovieTrailerViewHolder movieTrailerViewHolder = new MovieTrailerViewHolder(movieTrailer);
        return movieTrailerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 8;
    }
}
