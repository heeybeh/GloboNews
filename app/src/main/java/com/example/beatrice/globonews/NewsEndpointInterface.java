package com.example.beatrice.globonews;

import retrofit2.Call;
import retrofit2.http.GET;


public interface NewsEndpointInterface {

    @GET("./")
    Call<EditorialModel> getEditorial();
}
