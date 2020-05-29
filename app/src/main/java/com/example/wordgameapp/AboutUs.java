package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity {

    private Button btnBack;
    private TextView tvNameAronBelmonte, tvNameFrankFelarca;
    private MediaPlayer musicPlayer;
    private int musicPosition;

    @Override
    protected void onPause() {
        super.onPause();
        musicPosition = musicPlayer.getCurrentPosition();
        musicPlayer.stop();
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicPosition = musicPlayer.getCurrentPosition();
        musicPlayer.stop();

    }

    @Override
    protected void onResume() {
        super.onResume();
        musicPlayer.seekTo(musicPosition);
        musicPlayer.start();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        tvNameAronBelmonte = findViewById(R.id.tvNameAronBelmonte);
        tvNameFrankFelarca = findViewById(R.id.tvNameFrankFelarca);
        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        });

        Intent intent = getIntent();
        musicPosition = intent.getIntExtra("musicPosition", 0);

        musicPlayer = MediaPlayer.create(this, R.raw.terrariajourneysendrelogic2);
        musicPlayer.start();
        musicPlayer.setLooping(true);

        tvNameFrankFelarca.setText("Frank Joseph M. Felarca\n" +
                "Lead System Developer\n" +
                "2015079670@ust-ics.mygbiz.com");
        tvNameAronBelmonte.setText("John Aron D. Belmonte\n" +
                "Lead System Designer\n" +
                "2015084561@ust-ics.mygbiz.com");
    }
}
