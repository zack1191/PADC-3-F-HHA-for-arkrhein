package com.hha.heinhtetaung.movieshelf.events;

import com.hha.heinhtetaung.movieshelf.data.vo.PopularMoviesVO;

import java.util.List;

/**
 * Created by E5 on 12/30/2017.
 */

public class LoadedMoviesEvent {
    private List<PopularMoviesVO> moviesList;

    public LoadedMoviesEvent(List<PopularMoviesVO> moviesList) {
        this.moviesList = moviesList;
    }

    public List<PopularMoviesVO> getMoviesList() {
        return moviesList;
    }
}
