package com.example.hp.products_task.model;

import com.google.gson.annotations.SerializedName;

public class Image {
    @SerializedName("width")
         private int width;
    @SerializedName("height")
         private int height;
    @SerializedName("url")
         private String url;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getUrl() {
        return url;
    }
}
