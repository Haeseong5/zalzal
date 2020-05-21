package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;

    public Boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}