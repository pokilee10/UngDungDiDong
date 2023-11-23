package com.example.lab2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayAdapter<String> adapter;
    ListView lvDS;
    TextView tvInf;
    ArrayList<String> arrayName;
    Button btNhap;
    EditText edName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInf = (TextView) findViewById(R.id.tvInf);
        lvDS = (ListView) findViewById(R.id.lvDS);
        edName = (EditText) findViewById(R.id.editName);

        btNhap = (Button) findViewById(R.id.btNhap);
        arrayName = new ArrayList<>();
        arrayName.add("Tèo");
        arrayName.add("Tý");
        arrayName.add("Bin");
        arrayName.add("Bo");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arrayName);
        lvDS.setAdapter(adapter);
        btNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten = edName.getText().toString();
                arrayName.add(ten);
                adapter.notifyDataSetChanged();
                edName.getText().clear();
            }
        });
        lvDS.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                String value = lvDS.getItemAtPosition(position).toString();
                tvInf.setText("position :" + position+ " ; value =" + value);
            }
        });
        lvDS.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                arrayName.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}