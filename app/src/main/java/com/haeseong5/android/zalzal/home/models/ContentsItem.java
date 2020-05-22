package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

public class ContentsItem {
    @SerializedName("bannerImg")
    private String image;
    @SerializedName("bannerText")
    private String title;
    @SerializedName("bannerSub")
    private String writer;

    private String like;

    private String content;

    private String url;

    public ContentsItem(){}
    public ContentsItem(String image, String title, String writer, String like) {
        this.image = image;
        this.title = title;
        this.writer = writer;
        this.like = like;
    }

    public ContentsItem(String image, String title, String writer, String like, String content, String url) {
        this.image = image;
        this.title = title;
        this.writer = writer;
        this.like = like;
        this.content = content;
        this.url = url;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getLike() {
        return like;
    }

    public void setLike(String like) {
        this.like = like;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
