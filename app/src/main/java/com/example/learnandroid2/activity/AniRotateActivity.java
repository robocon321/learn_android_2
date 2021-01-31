package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.learnandroid2.R;

public class AniRotateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ani_rotate);
        ImageView imgRotate = findViewById(R.id.imgRotate);
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);

        imgRotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(anim);
            }
        });
    }
}