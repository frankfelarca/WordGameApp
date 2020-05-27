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
    private int musicPosition;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        musicPlayer.stop();
        finish();
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
                startActivity(intent);
            }
        });

        btnEasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EasyDifficulty.class);
                startActivity(intent);
            }
        });

        btnAverage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AverageDifficulty.class);
                startActivity(intent);
            }
        });

        btnHard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HardDifficulty.class);
                startActivity(intent);
            }
        });
    }
}
