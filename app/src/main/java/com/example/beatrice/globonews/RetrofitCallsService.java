package com.example.beatrice.globonews;


import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitCallsService implements CallsInterface {

    private final String URL = "http://falkor-cda.bastian.globo.com/feeds/b904b430-123a-4f93-8cf4-5365adf97892/posts/page/";

    private static RetrofitCallsService instance;


    public static RetrofitCallsService getInstance() {

        if (instance == null) {

            instance = new RetrofitCallsService();

        }

        return instance;
    }
    private Retrofit initRequest(String page) {

        return new Retrofit.Builder()
                .baseUrl(URL + page + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }


    @Override
    public void getNewsCall(final Context context) {

        try {

            NewsEndpointInterface service = initRequest("1").create(NewsEndpointInterface.class);

            Call<EditorialModel> call = service.getEditorial();

            call.enqueue(new Callback<EditorialModel>() {
                @Override
                public void onResponse(Call<EditorialModel> call, @NonNull Response<EditorialModel> response) {

                    EditorialModel editorialModel = new EditorialModel();


                    if (response.isSuccessful()) {

                        editorialModel = response.body();

                    } else {

                    }


                }

                @Override
                public void onFailure(Call<EditorialModel> call, Throwable t) {

                    Log.i("no", t.getMessage());

                }
            });


        } catch (Exception e) {

            e.printStackTrace();

        }

    }


}