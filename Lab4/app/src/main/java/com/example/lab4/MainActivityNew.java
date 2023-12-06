package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivityNew extends AppCompatActivity {
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_new);
    }
    public void openActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.anim_move_in_right, R.anim.anim_move_out_right);
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.anim_move_in_right, R.anim.anim_move_out_right);
    }
}