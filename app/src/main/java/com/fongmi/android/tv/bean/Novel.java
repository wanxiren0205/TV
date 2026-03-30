package com.fongmi.tv.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;

public class Novel implements Serializable {
    @SerializedName("id") private String id;
    @SerializedName("name") private String name;
    @SerializedName("cover") private String cover;
    @SerializedName("desc") private String desc;
    @SerializedName("chapters") private List<Chapter> chapters;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getCover() { return cover; }
    public String getDesc() { return desc; }
    public List<Chapter> getChapters() { return chapters; }

    public static class Chapter implements Serializable {
        @SerializedName("id") private String id;
        @SerializedName("name") private String name;
        public String getId() { return id; }
        public String getName() { return name; }
    }
}
