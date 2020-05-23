package com.haeseong5.android.zalzal.home;


import android.util.Log;

import com.haeseong5.android.zalzal.home.interfaces.HomeActivityView;
import com.haeseong5.android.zalzal.home.interfaces.HomeRetrofitInterface;
import com.haeseong5.android.zalzal.home.models.PickResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.haeseong5.android.zalzal.ApplicationClass.getRetrofit;


public class HomeService {
    private final HomeActivityView mHomeActivityView;

    public HomeService(final HomeActivityView homeActivityView) {
        this.mHomeActivityView = homeActivityView;
    }

    public void getPicks() {
        final HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        homeRetrofitInterface.getPicks().enqueue(new Callback<PickResponse>() {
            @Override
            public void onResponse(Call<PickResponse> call, Response<PickResponse> response) {
                final PickResponse pickResponse = response.body();
                if (pickResponse == null) {
                    mHomeActivityView.validateFailure("fail");
                    Log.d("Service s", "Null값 반환");
                    return;
                }

                mHomeActivityView.validateSuccess(pickResponse.getMessage(), pickResponse.getCode(), pickResponse.isSuccess(),pickResponse.getResult());
            }

            @Override
            public void onFailure(Call<PickResponse> call, Throwable t) {
                mHomeActivityView.validateFailure("fail");
                Log.d("Service s", "요청실패");
            }
        });
    }


}
