package com.example.learnandroid2.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class ConnectionBroadcast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("intent",intent.toString());
        Toast.makeText(context, "Network change", Toast.LENGTH_SHORT).show();
    }
}
