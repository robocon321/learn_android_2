package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.learnandroid2.R;

public class AnimationActivity extends AppCompatActivity {
    Button btnAlpha, btnRotate, btnForwardActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        addControls();
        setEvents();
    }

    public void addControls(){
        btnAlpha = findViewById(R.id.btnAlpha);
        btnRotate = findViewById(R.id.btnRotate);
        btnForwardActivity = findViewById(R.id.btnForwardActivity);
    }

    public void setEvents(){
        btnAlpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationActivity.this, AniAlphaActivity.class);
                startActivity(intent);
            }
        });

        btnRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationActivity.this, AniRotateActivity.class);
                startActivity(intent);
            }
        });

        btnForwardActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnimationActivity.this, AniForwardIntentActivity.class);
                startActivity(intent);
            }
        });
    }
}