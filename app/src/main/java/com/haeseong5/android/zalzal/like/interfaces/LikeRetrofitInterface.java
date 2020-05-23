package com.haeseong5.android.zalzal.like.interfaces;
import com.haeseong5.android.zalzal.home.models.ContentsResponse;
import com.haeseong5.android.zalzal.home.models.PickResponse;
import com.haeseong5.android.zalzal.like.models.LikeResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface LikeRetrofitInterface {
    @GET("/likes")
    Call<LikeResponse> getLikes();

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
