package com.haeseong5.android.zalzal.signup.interfaces;

public interface SignUpActivityView {
    void validateSuccess(boolean isSuccess, String message, int code);

    void validateFailure(String message);
}
