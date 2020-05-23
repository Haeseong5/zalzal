package com.haeseong5.android.zalzal.login.interfaces;

import com.haeseong5.android.zalzal.login.models.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface LoginRetrofitInterface {
//    @GET("/banner")
//    Call<DefaultResponse> getTest();
//
//    @GET("/jwt")
//    Call<SplashResponse> getValidatedJwt();
//
//    @GET("/test/{number}")
//    Call<SplashResponse> getTestPathAndQuery(
//            @Path("number") int number,
//            @Query("content") final String content
//    );
//
    @POST("/user")
    Call<LoginResponse> postLogin(@Body HashMap<String, Object> hashMap);

    @POST("/endgame/google/signin")
    Call<LoginResponse> postValidateGoogle(@Body HashMap<String, Object> hashMap);

}
