package com.example.beatrice.globonews;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class EditorialModel {

    @SerializedName("id")
    String id;

    @SerializedName("items")
    ArrayList<ItemsModel>  items;

    @SerializedName("itemCount")
    String itemCount;

    @SerializedName("limit")
    String limit;

    @SerializedName("perPage")
    String perPage;

    @SerializedName("nextPage")
    String nextPage;

    @SerializedName("source")
    String source;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public ArrayList<ItemsModel> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemsModel> items) {
        this.items = items;
    }


    public String getItemCount() {
        return itemCount;
    }

    public void setItemCount(String itemCount) {
        this.itemCount = itemCount;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getPerPage() {
        return perPage;
    }

    public void setPerPage(String perPage) {
        this.perPage = perPage;
    }

    public String getNextPage() {
        return nextPage;
    }

    public void setNextPage(String nextPage) {
        this.nextPage = nextPage;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
