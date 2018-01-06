package com.hha.heinhtetaung.movieshelf.Network.responses;

import com.google.gson.annotations.SerializedName;
import com.hha.heinhtetaung.movieshelf.data.vo.PopularMoviesVO;

import java.util.List;

/**
 * Created by E5 on 12/30/2017.
 */

public class GetMoviesResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    @SerializedName("popular-movies")
    private List<PopularMoviesVO> popularMovies;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<PopularMoviesVO> getPopularMovies() {
        return popularMovies;
    }
}
