package com.hha.heinhtetaung.movieshelf.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hha.heinhtetaung.movieshelf.R;
import com.hha.heinhtetaung.movieshelf.data.vo.PopularMoviesVO;
import com.hha.heinhtetaung.movieshelf.delegate.MoviesActionDelegate;
import com.hha.heinhtetaung.movieshelf.viewholders.MovieViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by E5 on 12/7/2017.
 */

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {
    private MoviesActionDelegate mMoviesActionDelegate;
    private List<PopularMoviesVO> mMoviesList;

    public MovieAdapter(MoviesActionDelegate moviesActionDelegate) {
        mMoviesActionDelegate = moviesActionDelegate;
        mMoviesList = new ArrayList<>();
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View newsItemView = layoutInflater.inflate(R.layout.item_movies, parent, false);
        MovieViewHolder movieViewHolder = new MovieViewHolder(newsItemView, mMoviesActionDelegate);
        return movieViewHolder;
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        holder.setMovies(mMoviesList.get(position));
    }


    @Override
    public int getItemCount() {
        return mMoviesList.size();
    }

    public void setMovies(List<PopularMoviesVO> moviesList) {
        mMoviesList = moviesList;
        notifyDataSetChanged();
    }
}
