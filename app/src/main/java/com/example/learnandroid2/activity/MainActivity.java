package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid2.R;

public class MainActivity extends AppCompatActivity {
    Button btnSharedPre, btnAnimation, btnAsyncTaskBasic, btnAsyncLoadImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        setEvents();
    }

    public void addControls(){
        btnSharedPre = findViewById(R.id.btnSharedPre);
        btnAnimation = findViewById(R.id.btnAnimation);
        btnAsyncTaskBasic = findViewById(R.id.btnAsyncTaskBasic);
        btnAsyncLoadImage = findViewById(R.id.btnAsyncLoadImage);
    }

    public void setEvents(){
        btnSharedPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SharedPreActivity.class);
                startActivity(intent);
            }
        });

        btnAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimationActivity.class);
                startActivity(intent);
            }
        });

        btnAsyncTaskBasic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskBasicActivity.class);
                startActivity(intent);
            }
        });

        btnAsyncLoadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AsyncTaskLoadImageActivity.class);
                startActivity(intent);
            }
        });
    }
}