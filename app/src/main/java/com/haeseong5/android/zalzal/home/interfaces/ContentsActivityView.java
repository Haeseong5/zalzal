package com.haeseong5.android.zalzal.home.interfaces;

import com.haeseong5.android.zalzal.home.models.ContentsResponse;

public interface ContentsActivityView {

    void validateSuccess(String text, int code, boolean isSuccess, ContentsResponse.Result result);

    void validateFailure(String message);

}
