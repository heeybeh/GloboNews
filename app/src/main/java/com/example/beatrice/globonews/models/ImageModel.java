package com.example.beatrice.globonews.models;

import com.google.gson.annotations.SerializedName;

public class ImageModel {

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @SerializedName("url")
    String  url;



}
