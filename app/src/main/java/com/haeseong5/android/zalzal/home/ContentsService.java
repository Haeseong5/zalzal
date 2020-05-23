package com.haeseong5.android.zalzal.home;
import android.util.Log;

import com.haeseong5.android.zalzal.home.interfaces.HomeRetrofitInterface;
import com.haeseong5.android.zalzal.home.interfaces.ContentsActivityView;
import com.haeseong5.android.zalzal.home.models.ContentsResponse;
import com.haeseong5.android.zalzal.home.models.HeartResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.haeseong5.android.zalzal.ApplicationClass.getRetrofit;


public class ContentsService {
    private final ContentsActivityView contentsActivityView;

    public ContentsService(final ContentsActivityView contentsActivityView) {
        this.contentsActivityView = contentsActivityView;
    }

    public void getContentsList(int pick_id) {
        Log.d("Service s", "try get picks");

        final HomeRetrofitInterface homeRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        homeRetrofitInterface.getContentsList(pick_id).enqueue(new Callback<ContentsResponse>() {
            @Override
            public void onResponse(Call<ContentsResponse> call, Response<ContentsResponse> response) {
                final ContentsResponse contentsResponse = response.body();
                if (contentsResponse == null) {
                    contentsActivityView.validateFailure("fail");
                    Log.d("Service s", "Null값 반환");
                    return;
                }

                contentsActivityView.validateSuccess(
                        contentsResponse.getMessage(),
                        contentsResponse.getCode(),
                        contentsResponse.isSuccess(),
                        contentsResponse.getResult());
            }

            @Override
            public void onFailure(Call<ContentsResponse> call, Throwable t) {
                contentsActivityView.validateFailure("fail");
                Log.e("Service s", "요청실패",t);
            }
        });
    }

    public void postHeart(int video_id) {
        final HomeRetrofitInterface mainRetrofitInterface = getRetrofit().create(HomeRetrofitInterface.class);
        mainRetrofitInterface.postHeart(video_id).enqueue(new Callback<HeartResponse>() {
            @Override
            public void onResponse(Call<HeartResponse> call, Response<HeartResponse> response) {
                final HeartResponse heartResponse = response.body();
                if (heartResponse == null) {
                    contentsActivityView.validateFailure(null);
                    return;
                }

                contentsActivityView.validateSuccessHeart(
                        heartResponse.getMessage(),
                        heartResponse.getCode(),
                        heartResponse.getSuccess(),
                        heartResponse.getResult().getStatus()
                        );
            }

            @Override
            public void onFailure(Call<HeartResponse> call, Throwable t) {
                contentsActivityView.validateFailure(null);
            }
        });
    }
}
