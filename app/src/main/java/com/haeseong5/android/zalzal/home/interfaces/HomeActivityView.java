package com.haeseong5.android.zalzal.home.interfaces;

import com.haeseong5.android.zalzal.home.models.PickResponse;

import java.util.ArrayList;

public interface HomeActivityView {

    void validateSuccess(String text, int code, boolean isSuccess, ArrayList<PickResponse.Pick> result);

    void validateFailure(String message);
}
