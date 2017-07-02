package com.example.marian.mercadolibre.API;

import com.example.marian.mercadolibre.Models.Article;
import com.google.gson.Gson;

import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Marian on 26/5/2017.
 */

public class API {
    private static MercadoLibreAPI getAPI() {
        Retrofit retrofit = new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create( new Gson() )).baseUrl("https://api.mercadolibre.com/").build();
        MercadoLibreAPI service = retrofit.create(MercadoLibreAPI.class);
        return service;
    }

    public static void getArticle(String id, Callback<Article> callback) {
        getAPI().getArticle(id).enqueue(callback);
    }
}
