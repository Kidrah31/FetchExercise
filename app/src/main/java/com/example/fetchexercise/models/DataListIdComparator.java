package com.example.fetchexercise.models;

import java.util.Comparator;

public class DataListIdComparator implements Comparator<Data> {

    @Override
    public int compare(Data obj1, Data obj2) {
        int l1=Integer.parseInt(obj1.getListId());
        int l2=Integer.parseInt(obj2.getListId());
        return  l1-l2;
    }
}
