package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.learnandroid2.R;
import com.example.learnandroid2.utils.BoundService;

public class BoundServiceActivity extends AppCompatActivity {
    boolean isBind = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bound_service);
        Button btnBind = findViewById(R.id.btnStartService);
        Button btnUnbind = findViewById(R.id.btnEndService);
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BoundServiceActivity.this, BoundService.class);
                bindService(intent, connection, BIND_AUTO_CREATE);
                isBind = true;
            }
        });

        btnUnbind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isBind){
                    Intent intent = new Intent(BoundServiceActivity.this, BoundService.class);
                    unbindService(connection);
                }
            }
        });
    }

    ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            BoundService.BoundExample boundExample = (BoundService.BoundExample) service;
            Toast.makeText(BoundServiceActivity.this, "onServiceConnedcted: "+ boundExample.getDescription(), Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Toast.makeText(BoundServiceActivity.this, "onServiceDisconnected", Toast.LENGTH_SHORT).show();
        }
    };
}