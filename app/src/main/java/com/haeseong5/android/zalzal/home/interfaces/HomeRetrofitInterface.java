package com.haeseong5.android.zalzal.home.interfaces;
import com.haeseong5.android.zalzal.home.models.PickResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HomeRetrofitInterface {
    @GET("/picks")
    Call<PickResponse> getPicks();


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
