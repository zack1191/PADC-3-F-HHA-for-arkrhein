package com.hha.heinhtetaung.movieshelf.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hha.heinhtetaung.movieshelf.R;
import com.hha.heinhtetaung.movieshelf.data.vo.PopularMoviesVO;
import com.hha.heinhtetaung.movieshelf.delegate.MoviesActionDelegate;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by E5 on 12/7/2017.
 */

public class MovieViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_justice)
    TextView tvTitle;

    @BindView(R.id.tv_rating_points)
    TextView tvRattingPoints;

    @BindView(R.id.iv_justice)
    ImageView ivPosterPath;

    private MoviesActionDelegate mMoviesActionDelegate;

    public MovieViewHolder(View itemView, MoviesActionDelegate moviesActionDelegate) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        mMoviesActionDelegate = moviesActionDelegate;

    }

    @OnClick(R.id.cv_item_movies)
    public void onMoviesItemTap(View view) {
        mMoviesActionDelegate.onTapMovieItems();
    }

    public void setMovies(PopularMoviesVO movies) {

        tvTitle.setText(movies.getTitle());
        tvRattingPoints.setText(movies.getVoteAverage());

        Glide.with(ivPosterPath.getContext())
                .load(" http://image.tmdb.org/t/p/original" + movies.getPosterPath())
                .into(ivPosterPath);


    }
}
