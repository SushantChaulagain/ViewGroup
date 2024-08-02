package com.example.SushantAndroidviewgroup;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidviewgroup.R;

import java.util.ArrayList;

public class GridviewAdapter extends AppCompatActivity {

    GridView gridView;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gridviewlayout);

        GridView gridView = findViewById(R.id.gridView);
        ArrayList<String> dataList = getIntent().getStringArrayListExtra("dataList");
        CustomAdapter adapter = new CustomAdapter(this, dataList);
        gridView.setAdapter(adapter);
    }
}
