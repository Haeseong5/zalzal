package com.haeseong5.android.zalzal.home.interfaces;

import com.haeseong5.android.zalzal.home.models.ContentsResponse;
import com.haeseong5.android.zalzal.home.models.HeartResponse;

public interface ContentsActivityView {

    void validateSuccess(String text, int code, boolean isSuccess, ContentsResponse.Result result);
    void validateSuccessHeart(String text, int code, boolean isSuccess, String status);

    void validateFailure(String message);

}
