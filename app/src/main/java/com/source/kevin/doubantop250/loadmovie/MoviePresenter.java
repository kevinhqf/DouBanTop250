package com.source.kevin.doubantop250.loadmovie;

import android.util.Log;

import com.source.kevin.doubantop250.data.HttpResult;
import com.source.kevin.doubantop250.data.Movie;
import com.source.kevin.doubantop250.service.MovieService;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * 具体的loadMovie模块的Presenter
 */
public class MoviePresenter implements MovieContract.Presenter {
    //持有View对象,用于对UI进行更新
    MovieContract.View mView;
    String BASIC_URL = "https://api.douban.com/v2/movie/";

    public MoviePresenter(MovieContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void refresh() {
        MovieService service = getMovieService();
        Call<HttpResult> call = service.getMovie(0, 25);
        call.enqueue(new Callback<HttpResult>() {
            @Override
            public void onResponse(Call<HttpResult> call, Response<HttpResult> response) {
                ArrayList<Movie> subjects = response.body().getSubjects();
                mView.refresh(subjects);
            }

            @Override
            public void onFailure(Call<HttpResult> call, Throwable t) {

            }
        });
    }

    private MovieService getMovieService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASIC_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit.create(MovieService.class);
    }

    @Override
    public void loadMore(int start) {
        Log.e("start", start + "");
        MovieService service = getMovieService();
        Call<HttpResult> call = service.getMovie(start, 25);
        call.enqueue(new Callback<HttpResult>() {
            @Override
            public void onResponse(Call<HttpResult> call, Response<HttpResult> response) {
                ArrayList<Movie> subjects = response.body().getSubjects();
                if (subjects != null) {
                    mView.loadMore(subjects);
                    mView.loadCompleted();
                }
            }

            @Override
            public void onFailure(Call<HttpResult> call, Throwable t) {

            }
        });
    }
}
