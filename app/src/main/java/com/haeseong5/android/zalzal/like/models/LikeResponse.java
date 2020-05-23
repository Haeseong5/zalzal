package com.haeseong5.android.zalzal.like.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class LikeResponse {
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
        private ArrayList<LikeItem> likeItems = null;

        public String getImageUrl() {
            return imageUrl;
        }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
        }

        public ArrayList<LikeItem> getLikeItems() {
            return likeItems;
        }

        public void setLikeItems(ArrayList<LikeItem> likeItems) {
            this.likeItems = likeItems;
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
