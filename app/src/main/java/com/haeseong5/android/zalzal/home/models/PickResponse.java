package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class PickResponse {
    @SerializedName("isSuccess")
    private Boolean isSuccess;
    @SerializedName("code")
    private Integer code;
    @SerializedName("message")
    private String message;
    @SerializedName("result")
    private ArrayList<Pick> result;

    public class Pick {
        @SerializedName("categoryId")
        private int categoryId;
        @SerializedName("categoryTitle")
        private String categoryTitle;
        @SerializedName("picks")
        private ArrayList<PickItem> pickItems = null;

        public int getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(int categoryId) {
            this.categoryId = categoryId;
        }

        public String getCategoryTitle() {
            return categoryTitle;
        }

        public void setCategoryTitle(String categoryTitle) {
            this.categoryTitle = categoryTitle;
        }

        public ArrayList<PickItem> getPickItems() {
            return pickItems;
        }

        public void setPickItems(ArrayList<PickItem> pickItems) {
            this.pickItems = pickItems;
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

    public ArrayList<Pick> getResult() {
        return result;
    }

    public void setResult(ArrayList<Pick> result) {
        this.result = result;
    }
}
