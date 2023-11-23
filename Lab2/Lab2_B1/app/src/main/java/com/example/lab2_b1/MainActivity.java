package com.example.lab2_b1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView lvDS;
    TextView tvInf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDS = findViewById(R.id.lvDS);
        tvInf = findViewById(R.id.tvInf);

        final String arr[] = {"Teo", "Ty", "Bin", "Bo"};
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, arr);
        lvDS.setAdapter(adapter);

        lvDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String value = adapter.getItem(position);
                tvInf.setText("Position: " + position + " ; Value: " + value);
            }
        });
    }
}