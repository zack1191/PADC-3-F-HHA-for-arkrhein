package com.hha.heinhtetaung.movieshelf.data.vo.Models;

import com.hha.heinhtetaung.movieshelf.Network.HttpUrlConnectionDataAgent;
import com.hha.heinhtetaung.movieshelf.Network.MoviesDataAgent;

/**
 * Created by E5 on 12/30/2017.
 */

public class MoviesModel {
    private static MoviesModel sObjInstance;
    private MoviesDataAgent mDataAgent;

    private MoviesModel() {
        mDataAgent = HttpUrlConnectionDataAgent.getsObjInstance();

    }

    public static MoviesModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new MoviesModel();
        }
        return sObjInstance;
    }

    public void loadMovies() {

        mDataAgent.loadMovies();
    }
}
