package com.haeseong5.android.zalzal.home.interfaces;
import com.haeseong5.android.zalzal.home.models.ContentsResponse;
import com.haeseong5.android.zalzal.home.models.HeartResponse;
import com.haeseong5.android.zalzal.home.models.PickResponse;
import com.haeseong5.android.zalzal.login.models.DefaultResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface HomeRetrofitInterface {
    @GET("/picks")
    Call<PickResponse> getPicks();
///picks/{pick-id}
    @GET("/picks/{pick-id}")
    Call<ContentsResponse> getContentsList(
                    @Path("pick-id") int pickId
    );

//    http://3.34.126.144/videos/9/like
    @POST("/videos/{video-id}/like")
    Call<HeartResponse> postHeart(
            @Path("video-id") int videoId
    );
//
//    @GET("/jwt")
//    Call<ColorResponse> getTest();
//
//    @GET("/test/{number}")
//    Call<ColorResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
//    @POST("/test")
//    Call<ColorResponse> postTest(@Body RequestBody params);
}
