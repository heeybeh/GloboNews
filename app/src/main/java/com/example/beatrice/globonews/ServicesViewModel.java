package com.example.beatrice.globonews;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.content.Context;

public class ServicesViewModel extends ViewModel {

    public MutableLiveData<ServiceResult> startServices(Context context) {

        MutableLiveData<ServiceResult> result = RetrofitCallsService.getInstance().getNewsCall(context);

        return result;
    }
}
