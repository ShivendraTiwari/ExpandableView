package com.example.expandableview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    List<String> names;
    Map<String, List<String>> movies;
    ExpandableListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        expandableListView = findViewById(R.id.main);
        fillData();
        listAdapter = new MyExpandableAdapter(this, names, movies);
        expandableListView.setAdapter(listAdapter);
    }

    public void fillData() {
        names = new ArrayList<>();
        movies = new HashMap<>();

        names.add("Amitabh Bacchan");
        names.add("Amir Khan");
        names.add("Rajkumar Rao");

        List<String> amitabh = new ArrayList<>();
        List<String> amir = new ArrayList<>();
        List<String> RajkumarRao = new ArrayList<>();

        amitabh.add("zanjeer");
        amitabh.add("sholay");
        amitabh.add("suryavansham");


        amir.add("Dhoom");
        amir.add("Tare Zameenm Par");
        amir.add("3 Idiots");

        RajkumarRao.add("Stree");
        RajkumarRao.add("Aligarh");
        RajkumarRao.add("Newton");


        movies.put(names.get(0),amitabh);
        movies.put(names.get(1),amir);
        movies.put(names.get(2),RajkumarRao);

    }

}