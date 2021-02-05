package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid2.R;

public class ServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        Button btnStartService = findViewById(R.id.btnStartService);
        Button btnBoundService = findViewById(R.id.btnBoundService);
        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, StartServiceActivity.class);
                startActivity(intent);
            }
        });
        btnBoundService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ServiceActivity.this, BoundServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}