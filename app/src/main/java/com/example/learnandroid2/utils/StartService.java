package com.example.learnandroid2.utils;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class StartService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(this, "OnBind", Toast.LENGTH_SHORT).show();
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if(intent != null) Toast.makeText(this, "OnStartCommand: "+intent.getStringExtra("data"), Toast.LENGTH_SHORT).show();
        else Toast.makeText(this, "OnStartCommand: null", Toast.LENGTH_SHORT).show();
        // mode : START_STICKY - START_NOT_STICKY - START_REDELIVER_INTENT
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
    }
}
