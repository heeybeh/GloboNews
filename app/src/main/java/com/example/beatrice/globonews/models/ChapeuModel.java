package com.example.beatrice.globonews.models;

import com.google.gson.annotations.SerializedName;


public class ChapeuModel {

    @SerializedName("label")
    String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}