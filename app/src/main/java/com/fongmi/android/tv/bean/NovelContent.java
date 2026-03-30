package com.fongmi.tv.bean;

import com.google.gson.annotations.SerializedName;

public class NovelContent {
    @SerializedName("title") private String title;
    @SerializedName("content") private String content;
    public String getTitle() { return title; }
    public String getContent() { return content; }
}
