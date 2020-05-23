package com.haeseong5.android.zalzal.like.interfaces;

import com.haeseong5.android.zalzal.home.models.PickResponse;
import com.haeseong5.android.zalzal.like.models.LikeResponse;

import java.util.ArrayList;

public interface LikeActivityView {

    void validateSuccess(String text, int code, boolean isSuccess, LikeResponse.Result result);

    void validateFailure(String message);
}
