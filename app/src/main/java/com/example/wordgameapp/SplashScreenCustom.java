package com.example.wordgameapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

public class SplashScreenCustom extends AppCompatActivity {
    TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen_custom);
        tvSplash = findViewById(R.id.tvSplashText);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                 tvSplash.setText("ONEONEONEONEONE");
            }
        }, 100);
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    tvSplash.setText("TWOTWOTWOTWOTWO");
                }
            },3000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenCustom.this, MainActivity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        },6000);
    }
}
