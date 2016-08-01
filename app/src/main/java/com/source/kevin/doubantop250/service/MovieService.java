package com.source.kevin.doubantop250.service;


import com.source.kevin.doubantop250.data.HttpResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MovieService {
    @GET("top250")
    Call<HttpResult> getMovie(@Query("start") int start,@Query("count") int count);
}
