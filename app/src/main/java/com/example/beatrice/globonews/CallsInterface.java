package com.example.beatrice.globonews;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

public interface CallsInterface {

    MutableLiveData<ServiceResult> getNewsCall(Context context);

}
