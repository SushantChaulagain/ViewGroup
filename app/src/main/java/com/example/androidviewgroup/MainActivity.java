package com.example.androidviewgroup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge, editTextProfession, editTextAddress;
    private Button data, list_View, grid_View, recycle_View;
    ArrayList<String> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        dataList = new ArrayList<>();

        editTextName = findViewById(R.id.editTextName);
        editTextAge = findViewById(R.id.editTextAge);
        editTextProfession = findViewById(R.id.editTextProfession);
        editTextAddress = findViewById(R.id.editTextAddress);

        data = findViewById(R.id.button1);
        list_View = findViewById(R.id.button2);
        grid_View = findViewById(R.id.button3);
        recycle_View = findViewById(R.id.button4);

        data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateInputs()) {
                    String name = editTextName.getText().toString();
                    String age = editTextAge.getText().toString();
                    String profession = editTextProfession.getText().toString();
                    String address = editTextAddress.getText().toString();

                    String data = "Name: " + name + ", Age: " + age + ", Profession: " + profession + ", Address: " + address;
                    dataList.add(data);
                    clearForm();
                } else {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                }
            }
        });

        list_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ListviewAdapter.class);
                intent.putStringArrayListExtra("dataList", dataList);
                startActivity(intent);
            }
        });

        grid_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GridviewAdapter.class);
                intent.putStringArrayListExtra("dataList", dataList);
                startActivity(intent);
            }
        });

        recycle_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerviewAdapter.class);
                intent.putStringArrayListExtra("dataList", dataList);
                startActivity(intent);
            }
        });
    }

    private boolean validateInputs() {
        return !editTextName.getText().toString().isEmpty() &&
                !editTextAge.getText().toString().isEmpty() &&
                !editTextProfession.getText().toString().isEmpty() &&
                !editTextAddress.getText().toString().isEmpty();
    }

    public void clearForm() {
        editTextName.setText("");
        editTextAge.setText("");
        editTextAddress.setText("");
        editTextProfession.setText("");
    }
}