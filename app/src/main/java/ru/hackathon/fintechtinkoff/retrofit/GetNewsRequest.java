package ru.hackathon.fintechtinkoff.retrofit;

import retrofit2.Call;
import retrofit2.http.GET;

public interface GetNewsRequest {
    @GET("/v1/news")
    Call<ArticleModel> getListNews();
}
