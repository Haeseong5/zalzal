package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

public class ContentsItem {
    @SerializedName("bannerImg")
    private String image;
    @SerializedName("bannerText")
    private String title;
    @SerializedName("bannerSub")
    private String subTitle;

    public ContentsItem(String image, String title, String subTitle) {
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
}
