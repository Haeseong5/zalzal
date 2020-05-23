package com.haeseong5.android.zalzal.login;


import android.content.SharedPreferences;

import com.haeseong5.android.zalzal.login.interfaces.LoginActivityView;
import com.haeseong5.android.zalzal.login.interfaces.LoginRetrofitInterface;
import com.haeseong5.android.zalzal.login.models.LoginResponse;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.haeseong5.android.zalzal.ApplicationClass.X_ACCESS_TOKEN;
import static com.haeseong5.android.zalzal.ApplicationClass.getRetrofit;
import static com.haeseong5.android.zalzal.ApplicationClass.sSharedPreferences;

public class LoginService {
    private final LoginActivityView mLoginActivityView;

    public LoginService(final LoginActivityView loginActivityView) {
        this.mLoginActivityView = loginActivityView;
    }

    void postLogin(String email, String pw) {
        HashMap<String, Object> hashMap = new HashMap<>();
        email = "test@naver.com";
        pw = "test123";
        hashMap.put("email", email);
        hashMap.put("pw", pw);

        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.postLogin(hashMap).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    mLoginActivityView.validateFailure(null);
                    return;
                }
                String jwt = loginResponse.getResult().getJwt() + "";
                if (jwt != null && jwt.length() != 0) {
                    SharedPreferences.Editor editor = sSharedPreferences.edit();
                    editor.putString(X_ACCESS_TOKEN, jwt).apply();
                }
                mLoginActivityView.validateSuccess(loginResponse.isSuccess(), loginResponse.getCode(), loginResponse.getMessage());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginActivityView.validateFailure(null);
            }
        });
    }

    void postValidateGoogleLogin(String token) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("email", token);

        final LoginRetrofitInterface loginRetrofitInterface = getRetrofit().create(LoginRetrofitInterface.class);
        loginRetrofitInterface.postValidateGoogle(hashMap).enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                final LoginResponse loginResponse = response.body();
                if (loginResponse == null) {
                    mLoginActivityView.validateFailure(null);
                    return;
                }
                String jwt = loginResponse.getResult().getJwt() + "";
                if (jwt != null && jwt.length() != 0) {
                    SharedPreferences.Editor editor = sSharedPreferences.edit();
                    editor.putString(X_ACCESS_TOKEN, loginResponse.getResult().getJwt()).apply();
                }
                mLoginActivityView.validateSuccess(loginResponse.isSuccess(), loginResponse.getCode(), loginResponse.getMessage());
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mLoginActivityView.validateFailure(null);
            }
        });
    }

}
