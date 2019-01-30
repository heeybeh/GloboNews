
package com.example.beatrice.globonews.services;


import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.beatrice.globonews.interfaces.CallsInterface;
import com.example.beatrice.globonews.interfaces.NewsEndpointInterface;
import com.example.beatrice.globonews.models.EditorialModel;
import com.example.beatrice.globonews.models.ItemsModel;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RetrofitCallsService implements CallsInterface {

    private static int page = 1;

    private final String URL = "http://falkor-cda.bastian.globo.com/feeds/b904b430-123a-4f93-8cf4-5365adf97892/posts/page/";

    private static RetrofitCallsService instance;

    public static RetrofitCallsService getInstance() {

        if (instance == null) {

            instance = new RetrofitCallsService();

        }

        return instance;
    }
    private Retrofit initRequest() {

        return new Retrofit.Builder()
                .baseUrl(URL + page + "/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

    }
    @Override
    public MutableLiveData<ServiceResult> getNewsCall(final Context context) {

        final MutableLiveData<ServiceResult> mutableDataServiceResult =
                new MutableLiveData<>();

        try {

            NewsEndpointInterface service = initRequest().create(NewsEndpointInterface.class);

            Call<EditorialModel> call = service.getEditorial();

            call.enqueue(new Callback<EditorialModel>() {
                @Override
                public void onResponse(Call<EditorialModel> call, @NonNull Response<EditorialModel> response) {

                    EditorialModel editorialModel;

                    if (response.isSuccessful()) {

                        editorialModel = response.body();

                        if (editorialModel != null) {

                            page = Integer.parseInt(editorialModel.getNextPage());

                            ArrayList<ItemsModel> data = new ArrayList<>(editorialModel.getItems());

                            ServiceResult serviceResult = new ServiceResult(data);

                            mutableDataServiceResult.setValue(serviceResult);


                        }
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

        return mutableDataServiceResult;

    }


}
