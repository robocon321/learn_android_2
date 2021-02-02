package com.example.learnandroid2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.learnandroid2.R;

public class MediaActivity extends AppCompatActivity {
    Button btnMusic, btnVideo;
    VideoView video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_media);
        addControls();
        setEvents();
    }

    public void addControls(){
        btnMusic = findViewById(R.id.btnMusic);
        btnVideo = findViewById(R.id.btnVideo);
        video = findViewById(R.id.video);
    }

    public void setEvents(){
        btnMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(MediaActivity.this, R.raw.anh_luon_la_ly_do_erik);
                mediaPlayer.start();
            }
        });

        btnVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                video.setVideoURI(Uri.parse("android:resource//"+getPackageName()+"/"+R.raw.videoplayback));
                MediaController controller = new MediaController(MediaActivity.this);
                controller.setMediaPlayer(video);
                video.setMediaController(controller);
                video.start();
            }
        });
    }
}