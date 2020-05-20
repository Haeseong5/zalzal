package com.haeseong5.android.zalzal.splash;


import com.haeseong5.android.zalzal.splash.interfaces.SplashActivityView;
import com.haeseong5.android.zalzal.splash.interfaces.SplashRetrofitInterface;
import com.haeseong5.android.zalzal.splash.models.AutoLoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.haeseong5.android.zalzal.ApplicationClass.getRetrofit;


public class SplashService {
    private final SplashActivityView mSplashActivityView;

    public SplashService(final SplashActivityView splashActivityView) {
        this.mSplashActivityView = splashActivityView;
    }

    public void getAutoLogin() {
        final SplashRetrofitInterface mainRetrofitInterface = getRetrofit().create(SplashRetrofitInterface.class);
        mainRetrofitInterface.getAutoLogin().enqueue(new Callback<AutoLoginResponse>() {
            @Override
            public void onResponse(Call<AutoLoginResponse> call, Response<AutoLoginResponse> response) {
                final AutoLoginResponse autoLoginResponse = response.body();
                if (autoLoginResponse == null) {
                    mSplashActivityView.validateFailure(null);
                    return;
                }

                mSplashActivityView.validateGetAutoLoginSuccess(autoLoginResponse.isSuccess(), autoLoginResponse.getMessage());
            }

            @Override
            public void onFailure(Call<AutoLoginResponse> call, Throwable t) {
                mSplashActivityView.validateFailure(null);
            }
        });
    }

}
