package com.haeseong5.android.zalzal.signup.interfaces;

import com.haeseong5.android.zalzal.signup.models.SignUpResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SignUpRetrofitInterface {

    @POST("/endgame/normal/signup")
    Call<SignUpResponse> postSignUp(@Body HashMap<String, Object> hashMap);

    @POST("/endgame/google/signup")
    Call<SignUpResponse> postSignUpGoogle(@Body HashMap<String, Object> hashMap);
}
