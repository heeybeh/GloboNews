package com.example.beatrice.globonews;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ContentModel {

    @SerializedName("chapeu")
    ChapeuModel chapeu;

    @SerializedName("image")
    ImageModel image;

    @SerializedName("section")
    String section;

    @SerializedName("summary")
    String summary;

    @SerializedName("title")
    String title;

    @SerializedName("url")
    String url;

    public ChapeuModel getChapeu() {
        return chapeu;
    }

    public void setChapeu(ChapeuModel chapeu) {
        this.chapeu = chapeu;
    }

    public ImageModel getImage() {
        return image;
    }

    public void setImage(ImageModel image) {
        this.image = image;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
