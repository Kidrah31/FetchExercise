package com.example.fetchexercise.models;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class DataChainedComparator implements Comparator<Data> {

    private List<Comparator<Data>> listComparators;

    @SafeVarargs
    public DataChainedComparator(Comparator<Data>... comparators) {
        this.listComparators = Arrays.asList(comparators);
    }

    @Override
    public int compare(Data obj1, Data obj2) {
        for (Comparator<Data> comparator : listComparators) {
            int result = comparator.compare(obj1, obj2);
            if (result != 0) {
                return result;
            }
        }
        return 0;
    }
}
