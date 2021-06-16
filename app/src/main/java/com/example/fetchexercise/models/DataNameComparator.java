package com.example.fetchexercise.models;

import java.util.Comparator;

public class DataNameComparator  implements Comparator<Data> {

    @Override
    public int compare(Data obj1, Data obj2) {
        return obj1.getName().compareTo(obj2.getName());
    }
}
