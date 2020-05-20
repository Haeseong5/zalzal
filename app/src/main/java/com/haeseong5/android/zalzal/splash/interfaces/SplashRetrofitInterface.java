package com.haeseong5.android.zalzal.splash.interfaces;


import com.haeseong5.android.zalzal.splash.models.AutoLoginResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SplashRetrofitInterface {

    @GET("/endgame/jwt")
    Call<AutoLoginResponse> getAutoLogin();
}
