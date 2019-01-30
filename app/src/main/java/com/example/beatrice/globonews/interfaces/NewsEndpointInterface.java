package com.example.beatrice.globonews.interfaces;

import com.example.beatrice.globonews.models.EditorialModel;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NewsEndpointInterface {

    @GET("./")
    Call<EditorialModel> getEditorial();
}
