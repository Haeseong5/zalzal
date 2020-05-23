package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

public class PickItem {
    @SerializedName("imgUrl")
    private String image;
    @SerializedName("title")
    private String title;
    @SerializedName("subTitle")
    private String subTitle;
    public PickItem(String image, String title, String subTitle) {
        this.image = image;
        this.title = title;
        this.subTitle = subTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    @Override
    public String toString() {
        return "PickItem{" +
                "image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                '}';
    }
}