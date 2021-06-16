package com.example.fetchexercise.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import static java.util.Objects.isNull;


public class Data {
    String id;
    String listId;
    String name;
    public Data(JSONObject jsonObject) throws JSONException {
        id= jsonObject.getString("id");
        listId=jsonObject.getString("listId");
        name=jsonObject.getString("name");

    }
    public static void groupBy(List<Data> data) {

    }


    public static List<Data> fromJsonArray(JSONArray dataJsonArray) throws JSONException {
        List<Data> data=new ArrayList<>();
        for(int i=0;i<dataJsonArray.length();i++)
        {
            data.add(new Data(dataJsonArray.getJSONObject(i)));
        }
        Collections.sort(data, new DataChainedComparator(
                new DataListIdComparator(),//Sorting dataSet  by ListId
                new DataNameComparator())// Sorting dataSet by names
        );

        Iterator<Data> it = data.iterator();
        while (it.hasNext()) {
            Data result = it.next();
            if (result.getName().equals("")||result.getName().equals("null")) {// Filtering out blank and null names
                it.remove();
            }
        }

        return data;

    }

    public String getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
