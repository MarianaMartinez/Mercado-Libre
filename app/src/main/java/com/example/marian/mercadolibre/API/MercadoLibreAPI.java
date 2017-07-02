package com.example.marian.mercadolibre.API;

import com.example.marian.mercadolibre.Models.Article;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Marian on 26/5/2017.
 */

public interface MercadoLibreAPI {
    @GET("items/{itemId}")
    Call<Article> getArticle(@Path("itemId") String id);
    @GET("sites/MLA/search")
    Call<Article> search(@Query("q") String query);
}
