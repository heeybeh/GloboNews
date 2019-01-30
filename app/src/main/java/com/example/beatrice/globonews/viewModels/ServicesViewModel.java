package com.example.beatrice.globonews.viewModels;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

import com.example.beatrice.globonews.services.RetrofitCallsService;
import com.example.beatrice.globonews.services.ServiceResult;

public class ServicesViewModel extends ViewModel {

    public MutableLiveData<ServiceResult> startServices(Context context) {

        MutableLiveData<ServiceResult> result = RetrofitCallsService.getInstance().getNewsCall(context);

        return result;
    }
}
