package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvTitle, tvBuildVersion;
    private Button btnEasy, btnAverage, btnHard, btnAboutUs;
    private MediaPlayer musicPlayer;
    public static boolean shouldPlay = false;
    public int musicPosition;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicPlayer.stop();
        finish();
    }
    @Override
    protected void onStop() {
        super.onStop();
        if (!shouldPlay) {
            musicPlayer.pause();
            musicPosition = musicPlayer.getCurrentPosition();
        }
    }
    @Override
    protected void onResume(){
        super.onResume();
        if (musicPlayer != null) {
            musicPlayer.seekTo(musicPosition);
            musicPlayer.start();
            musicPlayer.setLooping(true);
        }
    }
    @Override
    protected void onPause(){
        super.onPause();
        if (shouldPlay) {
            musicPlayer.pause();
            musicPosition = musicPlayer.getCurrentPosition();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicPlayer = MediaPlayer.create(this, R.raw.terrariajourneysendrelogic2);
        musicPlayer.start();
        musicPlayer.setLooping(true);

        tvTitle = findViewById(R.id.tvTitleText);
        tvBuildVersion = findViewById(R.id.tvBuildConfig);
        btnAboutUs = findViewById(R.id.btnAboutUs);
        btnEasy = findViewById(R.id.btnEasy);
        btnAverage = findViewById(R.id.btnAverage);
        btnHard = findViewById(R.id.btnHard);

        tvBuildVersion.setText("version: " + BuildConfig.VERSION_NAME);

        btnAboutUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AboutUs.class);
                shouldPlay = true;
                startActivity(intent);
            }
        });

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EasyDifficulty.class);
                shouldPlay = true;
                startActivity(intent);
            }
        });

        btnAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AverageDifficulty.class);
                shouldPlay = true;
                startActivity(intent);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HardDifficulty.class);
                shouldPlay = true;
                startActivity(intent);
            }
        });
    }
}
