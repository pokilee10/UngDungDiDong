package com.example.lab2_b4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edtName;
    EditText edtID;
    CheckBox chbxManager;
    Button btnAdd;
    ListView lv_Employee;
    ArrayList<Employee> employees;
    EmployeeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = (EditText) findViewById(R.id.edName);
        edtID = (EditText) findViewById(R.id.edID);
        chbxManager = (CheckBox) findViewById(R.id.cbManager);
        btnAdd = (Button) findViewById(R.id.btADD);
        lv_Employee = (ListView) findViewById(R.id.lvDS);
        employees = new ArrayList<Employee>();

        adapter = new EmployeeAdapter(this, R.layout.item_employee,employees);
        lv_Employee.setAdapter(adapter);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                Employee employee = new Employee();
                if (chbxManager.isChecked())
                {
                    employee.setManager(true);
                }
                else
                {
                    employee.setManager(false);
                }
                employee.setFullName(name);
                //Đưa employee vào ArrayList
                employees.add(employee);
                edtName.getText().clear();
                edtID.getText().clear();
                chbxManager.setChecked(false);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
            }
        });
    }
}