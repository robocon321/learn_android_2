package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid2.R;
import com.example.learnandroid2.utils.StartService;

public class StartServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_service);

        Button btnStartService = findViewById(R.id.btnStartService);
        Button btnEndService = findViewById(R.id.btnEndService);

        btnStartService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartServiceActivity.this, StartService.class);
                intent.putExtra("data","Hello world");
                startService(intent);
            }
        });

        btnEndService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartServiceActivity.this, StartService.class);
                stopService(intent);
            }
        });
    }
}