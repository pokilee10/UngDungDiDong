package com.example.lab2_b3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvInf;
    EditText etId;
    EditText etName;
    RadioButton rd_chinhthuc, rdBtnKhong;
    RadioGroup rgType;
    Button btnNhap;
    ListView lvNV;
    ArrayList<Employee> employees;
    ArrayAdapter<Employee> adapter;
    Employee employee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInf = (TextView) findViewById(R.id.tvInf);
        etId = (EditText) findViewById(R.id.edMaNV);
        etName = (EditText) findViewById(R.id.edTenNV);
        rgType = (RadioGroup) findViewById(R.id.rgLoai);
        btnNhap = (Button) findViewById(R.id.btNhap);
        lvNV = (ListView) findViewById(R.id.lvDS);
        employees = new ArrayList<Employee>();
        adapter = new ArrayAdapter<Employee>(this, android.R.layout.simple_list_item_1,employees);
        lvNV.setAdapter(adapter);
        btnNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int radId = rgType.getCheckedRadioButtonId();
                String id = etId.getText().toString();
                String name = etName.getText().toString();
                if (radId == R.id.rdChinhThuc) {
                    //tạo instance là FullTime
                    employee = new Fulltime();
                } else {
                    //Tạo instance là Partime
                    employee = new Parttime();
                }
                //FullTime hay Partime thì cũng là Employee nên có các hàm này là hiển nhiên
                employee.setId(id);
                employee.setName(name);
                //Đưa employee vào ArrayList
                employees.add(employee);
                //Cập nhập giao diện
                adapter.notifyDataSetChanged();
                etId.getText().clear();
                etName.getText().clear();
                rgType.clearCheck();
            }
        });
        lvNV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?>parent, View view, int position, long id) {
//                        Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
                String value = lvNV.getItemAtPosition(position).toString();
                tvInf.setText("position : " + position+ " ; value = " + value);
            }
        });
        lvNV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                employees.remove(position);
                adapter.notifyDataSetChanged();
                return false;
            }
        });
    }
}