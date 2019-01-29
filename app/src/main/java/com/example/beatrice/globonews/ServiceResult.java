package com.example.beatrice.globonews;


import java.util.ArrayList;

public class ServiceResult {

    private ArrayList<ItemsModel> list;

    public ServiceResult(ArrayList<ItemsModel> list)
    {
        this.list = list;
    }

    public ArrayList<ItemsModel> getList() {
        return list;
    }

    public void setList(ArrayList<ItemsModel> list) {
        this.list = list;
    }
}
