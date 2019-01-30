package com.example.beatrice.globonews.services;


import com.example.beatrice.globonews.models.ItemsModel;

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
