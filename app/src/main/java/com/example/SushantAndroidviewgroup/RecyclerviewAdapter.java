package com.example.SushantAndroidviewgroup;
import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidviewgroup.R;

import java.util.ArrayList;

public class RecyclerviewAdapter extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> dataList;
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerviewlayout);

        recyclerView = findViewById(R.id.recyclerViewItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Retrieve the dataList from the intent
        dataList = getIntent().getStringArrayListExtra("dataList");

        // Create an adapter and set it to the RecyclerView
        adapter = new Adapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}