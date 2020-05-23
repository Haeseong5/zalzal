package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContentsResponse {
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private Result result;

    public class Result {
        @SerializedName("imgUrl")
        private String imageUrl;
        @SerializedName("videos")
        private ArrayList<ContentsItem> contentsItems = null;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public ArrayList<ContentsItem> getContentsItems() {
            return contentsItems;
        }

        public void setContentsItems(ArrayList<ContentsItem> contentsItems) {
            this.contentsItems = contentsItems;
        }
    }

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


    public Boolean getSuccess() {
        return isSuccess;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
