package com.haeseong5.android.zalzal.login.interfaces;

public interface LoginActivityView {

    void validateSuccess(boolean isSuccess, int code, String message);

    void validateFailure(String message);
}
