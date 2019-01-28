package com.example.beatrice.globonews;

public class DataModel {

    // Getter and Setter model for recycler view items
    private String title, location, year;
    private int image;

    public DataModel(String title, String location, String year, int image) {
        this.year = year;
        this.title = title;
        this.location = location;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getYear() {
        return year;
    }

    public int getImage() {
        return image;
    }
}