package com.haeseong5.android.zalzal.home.models;

import com.google.gson.annotations.SerializedName;

public class ContentsItem {

    @SerializedName("videoId")
    private int videoId;
    @SerializedName("title")
    private String title;
    @SerializedName("publisher")
    private String writer;
    @SerializedName("heart")
    private String like;
    @SerializedName("content")
    private String content;
    @SerializedName("url")
    private String url;
    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("keywords")
    private String keywords;

    public int getVideoId() {
        return videoId;
    }

    public void setVideoId(int videoId) {
        this.videoId = videoId;
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

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }
}
