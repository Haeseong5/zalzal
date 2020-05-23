package com.haeseong5.android.zalzal.like;

import android.util.Log;

import com.haeseong5.android.zalzal.home.interfaces.ContentsActivityView;
import com.haeseong5.android.zalzal.home.interfaces.HomeRetrofitInterface;
import com.haeseong5.android.zalzal.home.models.ContentsResponse;
import com.haeseong5.android.zalzal.like.interfaces.LikeActivityView;
import com.haeseong5.android.zalzal.like.interfaces.LikeRetrofitInterface;
import com.haeseong5.android.zalzal.like.models.LikeResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.haeseong5.android.zalzal.ApplicationClass.getRetrofit;


public class LikeService {
    private final LikeActivityView likeActivityView;

    public LikeService(final LikeActivityView likeActivityView) {
        this.likeActivityView = likeActivityView;
    }

    public void getLikes() {
        Log.d("Service s", "try get picks");

        final LikeRetrofitInterface likeRetrofitInterface = getRetrofit().create(LikeRetrofitInterface.class);
        likeRetrofitInterface.getLikes().enqueue(new Callback<LikeResponse>() {
            @Override
            public void onResponse(Call<LikeResponse> call, Response<LikeResponse> response) {
                final LikeResponse likeResponse = response.body();
                if (likeResponse == null) {
                    likeActivityView.validateFailure("fail");
                    Log.d("Service s", "Null값 반환");
                    return;
                }

                likeActivityView.validateSuccess(
                        likeResponse.getMessage(),
                        likeResponse.getCode(),
                        likeResponse.isSuccess(),
                        likeResponse.getResult()
                );
            }

            @Override
            public void onFailure(Call<LikeResponse> call, Throwable t) {
                likeActivityView.validateFailure("fail");
                Log.e("Service s", "요청실패",t);
            }
        });
    }
}
