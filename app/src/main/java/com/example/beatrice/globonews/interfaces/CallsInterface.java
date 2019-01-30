package com.example.beatrice.globonews.interfaces;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.example.beatrice.globonews.services.ServiceResult;

public interface CallsInterface {

    MutableLiveData<ServiceResult> getNewsCall(Context context);

}
